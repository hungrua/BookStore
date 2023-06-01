package bookshop.DTO;

public class BookCart {
	private Long id;
	private String name;
	private Long quantity;
	private Long price;
	private Long cart_id;
	private Long book_id;
	
	
	public BookCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getCart_id() {
		return cart_id;
	}
	public void setCart_id(Long user_id) {
		this.cart_id = user_id;
	}
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	
}
