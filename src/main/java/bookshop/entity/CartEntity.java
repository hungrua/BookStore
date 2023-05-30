package bookshop.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class CartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long total;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "cart")
	private List<BillEntity> bills;
	public Long getId() {
		return id;
	}
	
	@OneToMany(mappedBy = "cart")
	private List<BookCartEntity> bookCart;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<BillEntity> getBills() {
		return bills;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}

	public List<BookCartEntity> getBookCart() {
		return bookCart;
	}

	public void setBookCart(List<BookCartEntity> bookCart) {
		this.bookCart = bookCart;
	}
	
	
}
