package camati.example.user_management_rbac.application.services.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import camati.example.user_management_rbac.application.dto.user.AssignRoleRequestDto;
import camati.example.user_management_rbac.application.dto.user.CreateUserRequestDto;
import camati.example.user_management_rbac.application.dto.user.CreateUserResponseDto;
import camati.example.user_management_rbac.application.dto.user.UpdateUserRequestDto;
import camati.example.user_management_rbac.application.dto.user.UpdateUserResponseDto;
import camati.example.user_management_rbac.application.dto.user.UserDto;

public interface UserService {

  CreateUserResponseDto createUser(CreateUserRequestDto request);

  void assignRole(AssignRoleRequestDto request);

  
  List<UserDto> findAllUsers();

  Optional<UserDto> findByUuid(UUID uuid);

 UpdateUserResponseDto update(UUID uuid, UpdateUserRequestDto updateRatingDto);

  void deleteByUuid(UUID uuid);
}
