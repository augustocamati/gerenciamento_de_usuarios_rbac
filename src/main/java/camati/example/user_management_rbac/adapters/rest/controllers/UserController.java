package camati.example.user_management_rbac.adapters.rest.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import camati.example.user_management_rbac.application.dto.user.CreateUserRequestDto;
import camati.example.user_management_rbac.application.dto.user.CreateUserResponseDto;
import camati.example.user_management_rbac.application.dto.user.UpdateUserRequestDto;
import camati.example.user_management_rbac.application.dto.user.UpdateUserResponseDto;
import camati.example.user_management_rbac.application.dto.user.UserDto;
import camati.example.user_management_rbac.application.services.user.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  // Criar usuário
  @PostMapping
  public ResponseEntity<CreateUserResponseDto> createUser(@Validated @RequestBody CreateUserRequestDto request) {
    CreateUserResponseDto response = userService.createUser(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  // Atualizar usuário
  @PutMapping("/{id}")
  public ResponseEntity<UpdateUserResponseDto> updateUser(
      @PathVariable UUID id,
      @Validated @RequestBody UpdateUserRequestDto request) {
    UpdateUserResponseDto response = userService.update(id, request);
    return ResponseEntity.ok(response);
  }

  // Listar todos usuários
  @GetMapping
  public ResponseEntity<List<UserDto>> getAllUsers() {
    return ResponseEntity.ok(userService.findAll());
  }

  // Buscar usuário por ID
  @GetMapping("/{id}")
  public ResponseEntity<Optional<UserDto>> getUserById(@PathVariable UUID id) {
    return ResponseEntity.ok(userService.findByUuid(id));
  }

  // Deletar usuário
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
    userService.deleteByUuid(id);
    return ResponseEntity.noContent().build();
  }
}