package bookshop.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity()
@Table(name="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String userName;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private RoleEntity role ;
	
	@OneToOne(mappedBy = "user")
	private CartEntity cart;
	public Long getId() {
		return id;
	}
	
	@OneToMany(mappedBy = "user")
	private List<CommentEntity> comments ;

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}
	
	
	
}
