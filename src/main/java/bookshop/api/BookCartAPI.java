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

import bookshop.DTO.BookCart;
import bookshop.service.IBookCartService;

@RestController
@CrossOrigin(origins="*")
public class BookCartAPI {
	@Autowired
	IBookCartService bookCartService;
	@PostMapping("/cart/add")
	public BookCart addToCart(@RequestBody BookCart bookCart) {
		return bookCartService.addToCart(bookCart);
	}
	
	@GetMapping("/cart/{id}")
	public List<BookCart> getByCartId(@PathVariable Long id){
		return bookCartService.getByCartId(id);
	}
	@DeleteMapping("/cart/delete/{id}")
	public Long deleteBookCart(@PathVariable Long id) {
		return bookCartService.deleteBookCart(id);
	}
	@PutMapping("/cart/edit")
	public void editBookCart(@RequestBody BookCart bookCart) {
		bookCartService.editBookCart(bookCart);
	}
}
