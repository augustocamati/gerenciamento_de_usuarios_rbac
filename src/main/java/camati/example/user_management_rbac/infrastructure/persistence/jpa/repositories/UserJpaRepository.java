package camati.example.user_management_rbac.infrastructure.persistence.jpa.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.UserJpaEntity;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, UUID> {
  Optional<UserJpaEntity> findByEmail(String email);

}
