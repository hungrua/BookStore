package bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.DTO.Category;
import bookshop.converter.CategoryConverter;
import bookshop.entity.CategoryEntity;
import bookshop.repository.CategoryRepository;
import bookshop.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	CategoryConverter categoryConverter;
	
	@Override
	public List<Category> getAll() {
		List<Category> result = new ArrayList<Category>();
		List<CategoryEntity> categories = categoryRepository.findAll();
		for(CategoryEntity x : categories) {
			result.add(categoryConverter.toDTO(x));
		}
		return result ;
	}

}
