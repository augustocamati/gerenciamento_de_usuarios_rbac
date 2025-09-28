package camati.example.user_management_rbac.domain.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import camati.example.user_management_rbac.domain.entities.User;


public interface UserRepository {
  User save(User user);
  Optional<User> findUserByEmail(String email);
  List<User> findAllUsers();
  Optional<User> findUserById(UUID id);
  void deleteById(UUID id);
}
