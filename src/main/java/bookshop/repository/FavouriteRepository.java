package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.entity.FavouriteEntity;

@Repository
public interface FavouriteRepository extends JpaRepository<FavouriteEntity,Long> {
	FavouriteEntity findByUser_IdAndBook_Id(Long user_id, Long book_id);
}
