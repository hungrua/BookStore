package bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.DTO.Bill;
import bookshop.DTO.BookCart;
import bookshop.converter.BillConverter;
import bookshop.converter.BookCartConverter;
import bookshop.entity.BillEntity;
import bookshop.entity.BookCartEntity;
import bookshop.entity.BookEntity;
import bookshop.entity.CartEntity;
import bookshop.repository.BillRepository;
import bookshop.repository.BookCartRepository;
import bookshop.repository.BookRepository;
import bookshop.repository.CartRepository;
import bookshop.service.IBillService;

@Service
public class BillService implements IBillService{
	
	@Autowired
	BillConverter billConverter;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	BillRepository billRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookCartRepository bookCartRepository;
	@Autowired
	BookCartConverter bookCartConverter;
	@Override
	public Bill addNewBill(Bill bill) {
		BillEntity entity = billConverter.toEntity(bill);
		CartEntity cart = cartRepository.findOne(bill.getCart_id());
		entity.setCart(cart);
		entity.setOrderDate( new java.sql.Date(System.currentTimeMillis()));
		entity = billRepository.save(entity);
		Long total = (long) 0;
		List<BookCartEntity> bill_book_cart = new ArrayList<>();
		for (BookCartEntity x : cart.getBookCart() ) {
			if(x.getStatus()==1) {
				bill_book_cart.add(x);
				x.setBill(entity);
				total+= x.getQuantity()*x.getBook().getPrice();
				BookEntity book = x.getBook();
				book.setSold(book.getSold()+x.getQuantity());
//				bookRepository.save(book);
				x.setStatus(0);
			}
		}
		entity.setBook_cart_list(bill_book_cart);
		entity.setTotal(total);
		return billConverter.toDTO(billRepository.save(entity));
	}
	@Override
	public List<Bill> getBillByCart(Long id) {
		List<BillEntity> bills = billRepository.findAllByCart_Id(id);
		List <Bill> result = new ArrayList<>();
		for(BillEntity x : bills) {
			Bill tmp = billConverter.toDTO(x);
			List<BookCart> list = new ArrayList<>(); 
			for (BookCartEntity y : x.getBook_cart_list()) {
				list.add(bookCartConverter.toDTO(y));
			}
			tmp.setItems(list);
			result.add(tmp);
		}
		return result;
	}
	@Override
	public void deleteBill(Long id) {
		BillEntity bill = billRepository.findOne(id);
		List<BookCartEntity> list = bill.getBook_cart_list();
		for (BookCartEntity x : list) {
			BookEntity book = x.getBook();
			book.setSold(book.getSold()-x.getQuantity());
			bookCartRepository.delete(x);
		}
		billRepository.delete(id);
	}
	@Override
	public Bill getPreviousBillInformation(Long id) {
		BillEntity bill = billRepository.getThePreviousBill(id);
		Bill result = new Bill();
		if(bill==null) return result;
		result.setAddress(bill.getAddress());
		result.setContact(bill.getContact());
		result.setReceiver(bill.getReceiver());
		result.setNotes(bill.getNotes());
		return result;
	}

	
	
	
	
	
}
