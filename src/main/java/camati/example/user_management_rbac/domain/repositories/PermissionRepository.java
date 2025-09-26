package camati.example.user_management_rbac.domain.repositories;

import java.util.List;
import java.util.Optional;

import camati.example.user_management_rbac.domain.entities.Permission;

public interface PermissionRepository {
  Permission save(Permission permission);
  Optional<Permission> findByName(String email);
  List<Permission> findAll();
  Optional<Permission> findById(Long id);
  void deleteById(Long id);
}
