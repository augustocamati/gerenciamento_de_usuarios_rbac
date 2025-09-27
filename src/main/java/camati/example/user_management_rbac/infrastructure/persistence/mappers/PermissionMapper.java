package camati.example.user_management_rbac.infrastructure.persistence.mappers;


import camati.example.user_management_rbac.domain.entities.Permission;
import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.PermissionJpaEntity;

public interface PermissionMapper {
 Permission toDomain(PermissionJpaEntity entity);

  PermissionJpaEntity toEntity(Permission domain);
}
