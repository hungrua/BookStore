package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshop.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
	CartEntity findByUser_Id(Long id);

}
