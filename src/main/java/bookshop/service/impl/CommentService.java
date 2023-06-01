package bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.DTO.Comment;
import bookshop.converter.CommentConverter;
import bookshop.entity.BookEntity;
import bookshop.entity.CommentEntity;
import bookshop.repository.BookRepository;
import bookshop.repository.CommentRepository;
import bookshop.repository.UserRepository;
import bookshop.service.ICommentService;

@Service
public class CommentService implements ICommentService {
	
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CommentConverter commentConverter;
	@Override
	public List<Comment> getAllCommentByBook(Long id) {
		List<Comment> result = new ArrayList<Comment>();
		List<CommentEntity> list = commentRepository.findAllByBook_Id(id);
		BookEntity book = bookRepository.findOne(id);
		Double sum = 0.0; 
		if(list.size()>0) {
			for(CommentEntity x : list) {
				sum+= x.getRate();
				result.add(commentConverter.toDTO(x));
			}
			Double rate = sum/list.size();
			book.setRate(rate);
		}
			
		bookRepository.save(book);
		return result;
	}

	@Override
	public Comment addComment(Comment comment) {
		CommentEntity entity = commentConverter.toEntity(comment);
		entity.setBook(bookRepository.findOne(comment.getBook_id()));
		entity.setUser(userRepository.findOne(comment.getUser_id()));
		entity.setCommentDate(new java.sql.Date(System.currentTimeMillis()));
		return commentConverter.toDTO(commentRepository.save(entity)) ;
	}

	@Override
	public void deleteComment(Long id) {
		commentRepository.delete(id);;
	}

	@Override
	public Comment editComment(Comment comment) {
		CommentEntity entity = commentRepository.findOne(comment.getId());
		entity.setContent(comment.getContent());
		entity.setRate(comment.getRate());
		entity.setCommentDate(new java.sql.Date(System.currentTimeMillis()));
		return commentConverter.toDTO(commentRepository.save(entity));
	}
}
