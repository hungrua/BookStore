package bookshop.converter;

import org.springframework.stereotype.Component;

import bookshop.DTO.BookCart;
import bookshop.entity.BookCartEntity;

@Component
public class BookCartConverter {
	
	public BookCartEntity toEntity(BookCart dto) {
		BookCartEntity entity = new BookCartEntity();
		entity.setQuantity(dto.getQuantity());
		entity.setStatus(1);		
		return entity;
	}
	public BookCart toDTO(BookCartEntity entity) {
		BookCart dto = new BookCart();
		dto.setId(entity.getId());
		dto.setBook_id(entity.getBook().getId());
		dto.setName(entity.getBook().getTitle());
		dto.setCart_id(entity.getCart().getId());
		dto.setQuantity(entity.getQuantity());
		dto.setPrice(entity.getBook().getPrice());
		return dto;
	}
}
