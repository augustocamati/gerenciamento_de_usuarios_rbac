package camati.example.user_management_rbac.infrastructure.persistence.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import camati.example.user_management_rbac.domain.entities.Role;
import camati.example.user_management_rbac.domain.repositories.RoleRepository;
import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.RoleJpaEntity;
import camati.example.user_management_rbac.infrastructure.persistence.jpa.repositories.RoleJpaRepository;
import camati.example.user_management_rbac.infrastructure.persistence.mappers.RoleMapper;
@Repository
public class RoleRepositoryAdapter implements RoleRepository {
  private final RoleJpaRepository roleJpaRepository;
  private final RoleMapper mapper;

  public RoleRepositoryAdapter(RoleJpaRepository roleJpaRepository, RoleMapper mapper) {
    this.roleJpaRepository = roleJpaRepository;
    this.mapper = mapper;
  }

  @Override
  public Role save(Role role) {
    RoleJpaEntity roleEntity = mapper.toEntity(role);
    return mapper.toDomain(roleJpaRepository.save(roleEntity));
  }

  @Override
  public Optional<Role> findByName(String name) {
    return roleJpaRepository.findByName(name).map(mapper::toDomain);
  }

  @Override
  public List<Role> findAll() {
    return roleJpaRepository
        .findAll()
        .stream()
        .map(mapper::toDomain)
        .toList();
  }

  @Override
  public Optional<Role> findById(Long id) {
    return roleJpaRepository.findById(id).map(mapper::toDomain);
  }

  @Override
  public void deleteById(Long id) {
    roleJpaRepository.deleteById(id);
  }

}
