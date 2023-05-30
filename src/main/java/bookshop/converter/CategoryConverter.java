package bookshop.converter;

import org.springframework.stereotype.Component;

import bookshop.DTO.Category;
import bookshop.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public Category toDTO(CategoryEntity entity) {
		Category dto = new Category();
		dto.setId(entity.getId());
		dto.setCategory(entity.getCode());
		return dto;
	}
}
