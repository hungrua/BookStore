package bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bookshop.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
	@Query(value="SELECT * FROM BOOK WHERE category_id=?",nativeQuery=true)
	List<BookEntity> findByCategory(@Param("category_id")Long id);
	@Query(value="SELECT * FROM BOOK where title=?1 and author=?2", nativeQuery = true)
	List<BookEntity> findByTitleAndAuthor(@Param("title") String title, @Param("author") String author);
}
