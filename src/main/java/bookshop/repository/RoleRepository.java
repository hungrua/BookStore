package bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookshop.entity.RoleEntity;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	
}
