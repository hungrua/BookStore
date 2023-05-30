package bookshop.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class CommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date commentDate;
	@Column
	private String content;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private BookEntity book;
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public BookEntity getBook() {
		return book;
	}
	public void setBook(BookEntity book) {
		this.book = book;
	}
	
	
}
