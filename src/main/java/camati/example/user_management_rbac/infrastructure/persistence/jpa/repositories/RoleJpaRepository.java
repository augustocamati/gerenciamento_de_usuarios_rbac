package camati.example.user_management_rbac.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.RoleJpaEntity;

public interface RoleJpaRepository extends JpaRepository<RoleJpaEntity, Long> {
   Optional<RoleJpaEntity> findByName(String name);
}
