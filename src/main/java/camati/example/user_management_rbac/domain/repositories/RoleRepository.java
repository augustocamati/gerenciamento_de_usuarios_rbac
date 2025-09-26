package camati.example.user_management_rbac.domain.repositories;

import java.util.List;
import java.util.Optional;

import camati.example.user_management_rbac.domain.entities.Role;

public interface RoleRepository {
  Role save(Role role);

  Optional<Role> findByName(String name);

  List<Role> findAll();

  Optional<Role> findById(Long id);

  void deleteById(Long id);
}
