package camati.example.user_management_rbac.application.services.user;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import camati.example.user_management_rbac.application.dto.user.AssignRoleRequestDto;
import camati.example.user_management_rbac.application.dto.user.CreateUserRequestDto;
import camati.example.user_management_rbac.application.dto.user.CreateUserResponseDto;
import camati.example.user_management_rbac.application.dto.user.UpdateUserRequestDto;
import camati.example.user_management_rbac.application.dto.user.UpdateUserResponseDto;
import camati.example.user_management_rbac.application.dto.user.UserDto;
import camati.example.user_management_rbac.domain.entities.User;
import camati.example.user_management_rbac.domain.repositories.RoleRepository;
import camati.example.user_management_rbac.domain.repositories.UserRepository;
import jakarta.transaction.Transactional;

public class UserServiceImp implements UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
  }

  @Override
  public CreateUserResponseDto createUser(CreateUserRequestDto request) {

    userRepository.findByEmail(request.email())
        .ifPresent(u -> {
          // throw new UserAlreadyExistsException(request.getEmail());
          throw new IllegalArgumentException("User with email " + request.email() + " already exists");
        });

    var roles = roleRepository.findByName("USER")
        .map(Set::of)
        .orElseThrow(() -> new IllegalStateException("Default role USER not found"));

    var domainUser = new User(request.name(), request.email(), request.password(), roles);
    var user = userRepository.save(domainUser);
    return new CreateUserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getPassword());
  }

  @Transactional
  @Override
  public void assignRole(AssignRoleRequestDto request) {
    var user = userRepository.findById(request.getUserId())
        .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + request.getUserId()));

    var role = roleRepository.findByName(request.getRoleName())
        .orElseThrow(() -> new IllegalArgumentException("Role not found with name: " + request.getRoleName()));

    user.addRole(role);
    userRepository.save(user);
  }

  @Override
  public List<UserDto> findAll() {
    return userRepository.findAll()
        .stream()
        .map(user -> new UserDto(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword()))
        .toList();
  }

  @Override
  public Optional<UserDto> findByUuid(UUID uuid) {
    return userRepository.findById(uuid).map(user -> new UserDto(
        user.getId(),
        user.getName(),
        user.getEmail(),
        user.getPassword()));
  }

  @Override
  public UpdateUserResponseDto update(UUID uuid, UpdateUserRequestDto updateRatingDto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void deleteByUuid(UUID uuid) {
   userRepository.deleteById(uuid);
  }

}
