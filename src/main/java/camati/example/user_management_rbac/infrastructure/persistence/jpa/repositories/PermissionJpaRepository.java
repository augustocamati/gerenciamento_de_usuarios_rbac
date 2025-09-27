package camati.example.user_management_rbac.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.PermissionJpaEntity;

public interface PermissionJpaRepository extends JpaRepository<PermissionJpaEntity, Long> {
  Optional<PermissionJpaEntity> findByName(String name);
}
