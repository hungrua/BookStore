package bookshop.service;

import java.util.List;

import bookshop.DTO.Comment;

public interface ICommentService {
	List<Comment> getAllCommentByBook(Long id);
	Comment addComment(Comment comment);
	void deleteComment(Long id);
	Comment editComment(Comment comment);
}
