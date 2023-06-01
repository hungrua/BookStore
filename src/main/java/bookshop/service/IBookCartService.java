package bookshop.service;

import java.util.List;

import bookshop.DTO.BookCart;

public interface IBookCartService{
	BookCart addToCart(BookCart dto);
	List<BookCart> getByCartId(Long id);
	Long deleteBookCart(Long id);
	void editBookCart(BookCart dto);
}
