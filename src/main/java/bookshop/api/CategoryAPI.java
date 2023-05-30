package bookshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bookshop.DTO.Category;
import bookshop.service.ICategoryService;

@RestController
@CrossOrigin(origins = "*")
public class CategoryAPI {
	
	@Autowired
	ICategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getCategory(){
		return categoryService.getAll();
	}
}
