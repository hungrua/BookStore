package bookshop.converter;

import org.springframework.stereotype.Component;

import bookshop.DTO.Comment;
import bookshop.entity.CommentEntity;

@Component
public class CommentConverter {
	
	public CommentEntity toEntity(Comment dto) {
		CommentEntity entity = new CommentEntity();
		if(dto.getId()!=null) {
			entity.setId(dto.getId());
		}
		entity.setContent(dto.getContent());
		entity.setRate(dto.getRate());
		return entity;
	}
	public Comment toDTO(CommentEntity entity) {
		Comment dto = new Comment();
		dto.setId(entity.getId());
		dto.setContent(entity.getContent());
		dto.setCommentDate(entity.getCommentDate());
		dto.setRate(entity.getRate());
		dto.setBook_id(entity.getBook().getId());
		dto.setUser_id(entity.getUser().getId());
		dto.setUser(entity.getUser().getUserName());
		return dto;
	}
}
