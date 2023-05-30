package bookshop.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String title;
	@Column 
	private String author;
	@Column
	private String description;
	@Column 
	private Date publishDate;
	@Column 
	private Long page;
	@Column
	private Long price;
	@Column 
	private Long sold;
	@Column 
	private Long rate;
	@Column
	private String image;
	
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private CategoryEntity category ;
	
	@OneToMany(mappedBy = "book")
	private List<BookCartEntity> books;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getSold() {
		return sold;
	}
	public void setSold(Long sold) {
		this.sold = sold;
	}
	public Long getRate() {
		return rate;
	}
	public void setRate(Long rate) {
		this.rate = rate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public List<BookCartEntity> getBooks() {
		return books;
	}
	public void setBooks(List<BookCartEntity> books) {
		this.books = books;
	}
	
	
	
	
	
}
