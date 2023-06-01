package bookshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bookshop.DTO.Comment;
import bookshop.service.ICommentService;

@RestController
@CrossOrigin(origins = "*")
public class CommentAPI {
	
	@Autowired
	ICommentService commentService;
	
	@GetMapping("/comment/book/{id}")
	List<Comment> getCommentByBook(@PathVariable Long id){
		return commentService.getAllCommentByBook(id);
	}
	@PostMapping("/comment/add")
	Comment addComment(@RequestBody Comment dto) {
		return commentService.addComment(dto);
	}
	@DeleteMapping("/comment/delete/{id}")
	void deleteComment(@PathVariable Long id) {
		commentService.deleteComment(id);
	}
	@PutMapping("/comment/edit")
	Comment editComment (@RequestBody Comment dto) {
		return commentService.editComment(dto);
	}
	
	
}
