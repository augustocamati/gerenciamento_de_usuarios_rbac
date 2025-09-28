package camati.example.user_management_rbac.application.dto.user;

import io.micrometer.common.lang.NonNull;

public record CreateUserRequestDto(
     String name,

     String email,

     String password) {

}
