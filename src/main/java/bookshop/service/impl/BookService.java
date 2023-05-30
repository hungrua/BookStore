package bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.DTO.Book;
import bookshop.converter.BookConverter;
import bookshop.entity.BookEntity;
import bookshop.repository.BookRepository;
import bookshop.repository.CategoryRepository;
import bookshop.service.IBookService;

@Service
public class BookService implements IBookService{
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookConverter bookConverter;
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Book> getAllBooks(Long id) {
		List<Book> result = new ArrayList<>();
		List<BookEntity> books = new ArrayList<>();
		if(id==0) books = bookRepository.findAll();
		else {
			books = bookRepository.findByCategory(id);
		}
		for(BookEntity x : books) {
			result.add(bookConverter.toDTO(x));
		}
		return result;
	}
	@Override
	public Book getOneBook(Long id) {
		Book book = bookConverter.toDTO(bookRepository.findOne(id));
		return book;
	}
	@Override
	public Book save(Book book) {
		Book result = new Book();
		BookEntity newBook = new BookEntity();
		if(checkAdd(book.getTitle(), book.getAuthor())==false) return result;
		else {
			newBook = bookConverter.toEntity(book);
			newBook.setSold((long) 0);
			newBook.setRate((long) 0);
			newBook.setCategory(categoryRepository.findOne(book.getCategory()));
			newBook = bookRepository.save(newBook);
			result = bookConverter.toDTO(newBook);
			return result ;
		}
	}
	
	public  boolean checkAdd(String title, String author) {
		List<BookEntity> books = bookRepository.findByTitleAndAuthor(title, author);
		if(books.size()==0) return true;
		else return false;
	}
	@Override
	public void delete(Long id) {
		bookRepository.delete(id);
	}
	@Override
	public Book update(Book book) {
		Book result = new Book();
		BookEntity newBook = new BookEntity();
		if(checkAdd(book.getTitle(), book.getAuthor())) return result;
		else {
			BookEntity oldBook = bookRepository.findOne(book.getId());
			newBook = bookConverter.toEntity(oldBook, book);
			newBook.setCategory(categoryRepository.findOne(book.getCategory()));
			bookRepository.save(newBook);
			result = bookConverter.toDTO(newBook);
			return result;
		}
	}
}
