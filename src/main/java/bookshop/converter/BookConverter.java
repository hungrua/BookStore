package bookshop.converter;

import org.springframework.stereotype.Component;

import bookshop.DTO.Book;
import bookshop.entity.BookEntity;
@Component
public class BookConverter {
	public BookEntity toEntity(Book dto) {
		BookEntity entity = new BookEntity();
		if(dto.getId()!=null) entity.setId(dto.getId());
		entity.setAuthor(dto.getAuthor());
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setPage(dto.getPage());
		entity.setPublishDate(dto.getPublishDate());
		entity.setPrice(dto.getPrice());
		entity.setRate(dto.getRate());
		entity.setSold(dto.getSold());
		entity.setImage(dto.getImage());
		return entity;
	}
	public Book toDTO(BookEntity entity) {
		Book book = new Book();
		book.setId(entity.getId());
		book.setAuthor(entity.getAuthor());
		book.setTitle(entity.getTitle());
		book.setDescription(entity.getDescription());
		book.setCategory(entity.getCategory().getId());
		book.setPublishDate(entity.getPublishDate());
		book.setPage(entity.getPage());
		book.setPrice(entity.getPrice());
		book.setSold(entity.getSold());
		book.setImage(entity.getImage());
		book.setCategory_code(entity.getCategory().getCode());
		book.setRate(entity.getRate());
		return book;
	}
	public BookEntity toEntity(BookEntity entity, Book dto) {
		entity.setId(dto.getId());
		entity.setAuthor(dto.getAuthor());
		entity.setTitle(dto.getTitle());
		entity.setPage(dto.getPage());
		entity.setDescription(dto.getDescription());
		entity.setPublishDate(dto.getPublishDate());
		entity.setPrice(dto.getPrice());
		entity.setRate(entity.getRate());
		entity.setSold(entity.getSold());
		entity.setImage(dto.getImage());
		return entity;
	}
}
