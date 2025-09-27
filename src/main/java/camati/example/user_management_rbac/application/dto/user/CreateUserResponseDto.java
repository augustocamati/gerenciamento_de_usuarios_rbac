package camati.example.user_management_rbac.application.dto.user;

import java.util.UUID;

public record CreateUserResponseDto(
    UUID id,
    String name,
    String email,
    String password) {
}
