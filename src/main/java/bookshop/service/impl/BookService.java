package bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.DTO.Book;
import bookshop.converter.BookConverter;
import bookshop.entity.BookCartEntity;
import bookshop.entity.BookEntity;
import bookshop.entity.CommentEntity;
import bookshop.entity.FavouriteEntity;
import bookshop.repository.BookCartRepository;
import bookshop.repository.BookRepository;
import bookshop.repository.CategoryRepository;
import bookshop.repository.CommentRepository;
import bookshop.repository.FavouriteRepository;
import bookshop.service.IBookService;

@Service
public class BookService implements IBookService{
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookCartRepository bookCartRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	FavouriteRepository favouriteRepository;
	@Autowired
	BookConverter bookConverter;
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Book> getAllBooks(Book book) {
		List<Book> result = new ArrayList<>();
		List<BookEntity> books = new ArrayList<>();
		if(book.getTitle()!="") {
			books = bookRepository.findByTitleKeyword(chuanHoa(book.getTitle()));
		}
		else {
			if(book.getCategory()==0) books = bookRepository.findAll();
			else {
				books = bookRepository.findByCategory(book.getCategory());
			}
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
			newBook.setRate((double) 0.0);
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
		BookEntity book = bookRepository.findOne(id);
		List<BookCartEntity> list_book_cart = book.getBooks();
		for(BookCartEntity x : list_book_cart) bookCartRepository.delete(x);
		List<FavouriteEntity> list_favourite = book.getFavourites();
		for(FavouriteEntity x :list_favourite) favouriteRepository.delete(x);
		List<CommentEntity> list_comment = book.getComments();
		for(CommentEntity x :list_comment) commentRepository.delete(x);
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
   private static String chuanHoa(String s) {
        StringBuilder result = new StringBuilder();
        StringTokenizer token = new StringTokenizer(s);
        while(token.hasMoreElements()) {
            String tmp = token.nextToken();
            result.append(tmp);
            result.append(" ");
        }
        return result.toString().trim();
    }
}
