package bookshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bookshop.DTO.Book;
import bookshop.service.IBookService;
@CrossOrigin(origins = "*")
@RestController
public class BookAPI {
	@Autowired
	IBookService bookService;
	
	@PostMapping("/book/condition")
	public List<Book> getBookByCategory(@RequestBody Book book){
		return bookService.getAllBooks(book);
	}
	
	@GetMapping("/book/{id}")
	public Book getOneBook(@PathVariable Long id) {
		return bookService.getOneBook(id);
	}
	
	@PostMapping("/book/add")
	public Book addBook(@RequestBody Book book) {
		return bookService.save(book);
	}
	@PutMapping("/book/edit")
	public Book editBook(@RequestBody Book book) {
		return bookService.update(book);
	}
	@DeleteMapping("/book/delete/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		bookService.delete(id);
	}
}
