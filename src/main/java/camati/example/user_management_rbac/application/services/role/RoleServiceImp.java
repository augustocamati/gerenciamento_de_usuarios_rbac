package camati.example.user_management_rbac.application.services.role;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import camati.example.user_management_rbac.application.dto.role.CreateRoleRequestDto;
import camati.example.user_management_rbac.application.dto.role.RoleDto;
import camati.example.user_management_rbac.application.dto.role.UpdateRoleRequestDto;
import camati.example.user_management_rbac.domain.entities.Role;
import camati.example.user_management_rbac.domain.repositories.RoleRepository;
import camati.example.user_management_rbac.infrastructure.persistence.mappers.RoleMapper;

@Service
public class RoleServiceImp implements RoleService {
  private final RoleRepository roleRepository;
  private final RoleMapper roleMapper;

  public RoleServiceImp(RoleRepository roleRepository, RoleMapper roleMapper) {
    this.roleRepository = roleRepository;
    this.roleMapper = roleMapper;
  }

  @Override
  public RoleDto create(CreateRoleRequestDto request) {

    var role = roleRepository.save(roleMapper.toDomain(request));
    return new RoleDto(role.getId(), role.getName(), role.getDescription());
  }


  @Override
  public List<RoleDto> findAll() {
    return roleRepository.findAll()
        .stream()
          .map(role -> new RoleDto(role.getId(), role.getName(), role.getDescription()))
          .collect(Collectors.toList());
   
  }

  @Override
  public Optional<RoleDto> findById(Long id) {
    return roleRepository.findById(id)
        .map(role -> new RoleDto(role.getId(), role.getName(), role.getDescription()));
  }

  @Override
  public RoleDto update(Long id, UpdateRoleRequestDto request) {

    Optional<Role> optionalRole = roleRepository.findById(id);
    if (optionalRole.isEmpty()) {
      throw new IllegalArgumentException("Usuário não encontrado para atualização");
    }

    Role role = optionalRole.get();

    if (request.getName() != null && !request.getName().isEmpty()) {
      role.setName(request.getName());
    }

    if (request.getDescription() != null && !request.getDescription().isEmpty()) {
      role.setDescription(request.getDescription());
    }


    role = roleRepository.save(role);

    return new RoleDto(role.getId(), role.getName(), role.getDescription());
  }

  @Override
  public void deleteById(Long id) {
    roleRepository.deleteById(id);
  }

}
