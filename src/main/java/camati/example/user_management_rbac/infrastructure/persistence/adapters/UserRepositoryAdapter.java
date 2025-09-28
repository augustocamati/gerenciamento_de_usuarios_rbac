package camati.example.user_management_rbac.infrastructure.persistence.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import camati.example.user_management_rbac.domain.entities.User;
import camati.example.user_management_rbac.domain.repositories.UserRepository;
import camati.example.user_management_rbac.infrastructure.persistence.jpa.entities.UserJpaEntity;
import camati.example.user_management_rbac.infrastructure.persistence.jpa.repositories.UserJpaRepository;
import camati.example.user_management_rbac.infrastructure.persistence.mappers.UserMapper;

public class UserRepositoryAdapter implements UserRepository {

  private final UserJpaRepository userJpaRepository;
  private final UserMapper mapper;

  public UserRepositoryAdapter(UserJpaRepository userJpaRepository, UserMapper mapper) {
    this.userJpaRepository = userJpaRepository;
    this.mapper = mapper;
  }

  @Override
  public User save(User user) {
    UserJpaEntity userEntity = mapper.toEntity(user);
    return mapper.toDomain(userJpaRepository.save(userEntity));
  }

  @Override
  public Optional<User> findUserByEmail(String email) {
    return userJpaRepository.findByEmail(email).map(mapper::toDomain);
  }

  @Override
  public List<User> findAllUsers() {
    return userJpaRepository.findAll()
        .stream()
        .map(mapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<User> findUserById(UUID id) {
    return userJpaRepository.findById(id).map(mapper::toDomain);
  }

  @Override
  public void deleteById(UUID id) {
    userJpaRepository.deleteById(id);
  }

}
