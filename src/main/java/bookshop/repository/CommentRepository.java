package bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long > {
	List<CommentEntity> findAllByBook_Id(Long id);
}
