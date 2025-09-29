package camati.example.user_management_rbac.application.dto.role;

import io.micrometer.common.lang.NonNull;

public record CreateUserRequestDto(
     String name,
     String description,

  
) {

}
