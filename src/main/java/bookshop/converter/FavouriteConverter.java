package bookshop.converter;

import org.springframework.stereotype.Component;

import bookshop.DTO.Favourite;
import bookshop.entity.FavouriteEntity;

@Component
public class FavouriteConverter {
	public FavouriteEntity toEntity (Favourite dto) {
		FavouriteEntity entity = new FavouriteEntity();
		return entity;
	}
	public Favourite toDTO(FavouriteEntity entity) {
		Favourite dto = new Favourite();
		dto.setId(entity.getId());
		dto.setTitle(entity.getBook().getTitle());
		dto.setPrice(entity.getBook().getPrice());
		dto.setImage(entity.getBook().getImage());
		dto.setBook_id(entity.getBook().getId());
		dto.setUser_id(entity.getUser().getId());
		return dto;
	}
}
