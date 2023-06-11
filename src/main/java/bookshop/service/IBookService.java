package bookshop.service;

import java.util.List;

import bookshop.DTO.Book;

public interface IBookService {
	List<Book> getAllBooks(Book book);
	Book getOneBook(Long id);
	Book save(Book book);
	Book update(Book book);
	void delete(Long id);
}
