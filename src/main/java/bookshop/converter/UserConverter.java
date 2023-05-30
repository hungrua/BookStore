package bookshop.converter;

import org.springframework.stereotype.Component;

import bookshop.DTO.User;
import bookshop.entity.UserEntity;

@Component
public class UserConverter {
	public UserEntity toEntity(User dto) {
		UserEntity entity = new UserEntity();
		if (dto.getId()!=null )entity.setId(dto.getId());
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setEmail(dto.getEmail());
		return entity;
	}
	public User toDTO(UserEntity entity) {
		User dto = new User();
		dto.setId(entity.getId());
		dto.setUserName(entity.getUserName());
		dto.setEmail(entity.getEmail());
		dto.setRole_id(entity.getRole().getId());
		return dto;
	}
}
	
