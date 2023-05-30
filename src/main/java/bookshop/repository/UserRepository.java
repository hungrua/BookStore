package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
//	@Query(value="SELECT * FROM user WHERE user_name=?",nativeQuery=true)
	UserEntity findByUserName(String username);
}
