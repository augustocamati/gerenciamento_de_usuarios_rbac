package camati.example.user_management_rbac.infrastructure.persistence.mappers;

import camati.example.user_management_rbac.application.dto.role.CreateRoleRequestDto;
import camati.example.user_management_rbac.domain.entities.Role;
import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.RoleJpaEntity;

public interface RoleMapper {

  Role toDomain(RoleJpaEntity entity);

  RoleJpaEntity toEntity(Role domain);

  CreateRoleRequestDto toDto(Role domain);

  Role toDomain(CreateRoleRequestDto dto);

}
