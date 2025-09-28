package camati.example.user_management_rbac.infrastructure.persistence.jpa.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import camati.example.user_management_rbac.domain.repositories.UserRepository;
import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.UserJpaEntity;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJpaEntity, UUID>, UserRepository {
  Optional<UserJpaEntity> findByEmail(String email);

}
