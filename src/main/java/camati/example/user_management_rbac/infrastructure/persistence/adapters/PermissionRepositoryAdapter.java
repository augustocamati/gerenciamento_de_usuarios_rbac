package camati.example.user_management_rbac.infrastructure.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import camati.example.user_management_rbac.domain.entities.Permission;
import camati.example.user_management_rbac.domain.repositories.PermissionRepository;
import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.PermissionJpaEntity;
import camati.example.user_management_rbac.infrastructure.persistence.jpa.repositories.PermissionJpaRepository;
import camati.example.user_management_rbac.infrastructure.persistence.mappers.PermissionMapper;

@Repository
public class PermissionRepositoryAdapter implements PermissionRepository {
  private final PermissionJpaRepository permissionJpaRepository;
  private final PermissionMapper mapper;

  public PermissionRepositoryAdapter(PermissionJpaRepository permissionJpaRepository, PermissionMapper mapper) {
    this.permissionJpaRepository = permissionJpaRepository;
    this.mapper = mapper;
  }

  @Override
  public Permission save(Permission permission) {
    PermissionJpaEntity roleEntity = mapper.toEntity(permission);
    return mapper.toDomain(permissionJpaRepository.save(roleEntity));
  }

  @Override
  public Optional<Permission> findByName(String name) {
    return permissionJpaRepository.findByName(name).map(mapper::toDomain);
  }

  @Override
  public List<Permission> findAll() {
    return permissionJpaRepository
        .findAll()
        .stream()
        .map(mapper::toDomain)
        .toList();
  }

  @Override
  public Optional<Permission> findById(Long id) {
    return permissionJpaRepository.findById(id).map(mapper::toDomain);
  }

  @Override
  public void deleteById(Long id) {
    permissionJpaRepository.deleteById(id);
  }

}
