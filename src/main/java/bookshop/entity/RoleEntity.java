package bookshop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String role_code;
	
	@OneToMany(mappedBy="role")
	private List <UserEntity> users= new ArrayList<UserEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}
	
	
}
