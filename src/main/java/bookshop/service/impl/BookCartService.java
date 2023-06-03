package bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.DTO.BookCart;
import bookshop.converter.BookCartConverter;
import bookshop.entity.BookCartEntity;
import bookshop.entity.BookEntity;
import bookshop.repository.BookCartRepository;
import bookshop.repository.BookRepository;
import bookshop.repository.CartRepository;
import bookshop.service.IBookCartService;
@Service
public class BookCartService implements IBookCartService {

	@Autowired
	BookCartConverter bookCartConverter;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookCartRepository bookCartRepository;
	
	@Override
	public BookCart addToCart(BookCart dto) {
		//Check xem sảm phẩm có trong giỏ hàng chưa
		if(bookCartRepository.findByCart_IdAndBook_IdAndStatus(dto.getCart_id(), dto.getBook_id(), 1)!=null) return new BookCart();
		BookCartEntity entity = bookCartConverter.toEntity(dto);
		BookEntity book = bookRepository.findOne(dto.getBook_id());
		entity.setCart(cartRepository.findOne(dto.getCart_id()));
		entity.setBook(book);
		BookCartEntity bookcart = bookCartRepository.save(entity);
		BookCart result =  bookCartConverter.toDTO(bookcart);
		result.setName(book.getTitle());
		return result;
	}

	@Override
	public List<BookCart> getByCartId(Long id) {
		List<BookCartEntity> list = bookCartRepository.findAllByCart_Id(id);
		List<BookCart> result= new ArrayList<BookCart>();
		for(BookCartEntity entity : list) {
			if(entity.getStatus()==1) {
				result.add(bookCartConverter.toDTO(entity));	
			}
			
		}
		return result;
	}

	@Override
	public Long deleteBookCart(Long id) {
		bookCartRepository.delete(id);
		return id;
	}

	@Override
	public void editBookCart(BookCart dto) {
		BookCartEntity entity = bookCartRepository.findOne(dto.getId());
		entity.setQuantity(dto.getQuantity());
		bookCartRepository.save(entity);
	}
}
