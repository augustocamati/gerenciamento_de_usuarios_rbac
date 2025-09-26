package camati.example.user_management_rbac.infrastructure.persistence.mappers;

import camati.example.user_management_rbac.domain.entities.User;
import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.UserJpaEntity;

public interface UserMapper {

  User toDomain(UserJpaEntity entity);

  UserJpaEntity toEntity(User domain);

}
