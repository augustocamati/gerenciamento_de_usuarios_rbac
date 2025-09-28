package camati.example.user_management_rbac.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.PermissionJpaEntity;

@Repository
public interface PermissionJpaRepository extends JpaRepository<PermissionJpaEntity, Long> {
  Optional<PermissionJpaEntity> findByName(String name);
}
