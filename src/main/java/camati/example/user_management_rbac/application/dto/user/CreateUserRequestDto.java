package camati.example.user_management_rbac.application.dto.user;

public record CreateUserRequestDto(
     String name,

     String email,

     String password) {

}
