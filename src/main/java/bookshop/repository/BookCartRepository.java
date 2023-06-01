package bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bookshop.entity.BookCartEntity;

public interface BookCartRepository extends JpaRepository<BookCartEntity, Long>{
	List<BookCartEntity> findAllByCart_Id(Long id);
	BookCartEntity findByCart_IdAndBook_IdAndStatus(Long cart_id,Long book_id,int status);
}
