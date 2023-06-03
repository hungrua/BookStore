package bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bookshop.entity.BillEntity;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {
	List<BillEntity> findAllByCart_Id(Long id);
	@Query(value="SELECT * FROM bill where cart_id = ? order by id desc limit 1", nativeQuery = true )
	BillEntity getThePreviousBill(@Param("cart_id") Long id);

}
