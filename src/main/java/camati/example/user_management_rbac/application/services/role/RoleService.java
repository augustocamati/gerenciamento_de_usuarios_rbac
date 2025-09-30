package camati.example.user_management_rbac.application.services.role;

import java.util.List;
import java.util.Optional;

import camati.example.user_management_rbac.application.dto.role.CreateRoleRequestDto;
import camati.example.user_management_rbac.application.dto.role.RoleDto;
import camati.example.user_management_rbac.application.dto.role.UpdateRoleRequestDto;



public interface RoleService {

  RoleDto create(CreateRoleRequestDto request);

  List<RoleDto> findAll();

  Optional<RoleDto> findById(Long id);

 RoleDto update(Long id, UpdateRoleRequestDto request);

  void deleteById(Long id);
}
