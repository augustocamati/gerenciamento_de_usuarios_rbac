package camati.example.user_management_rbac.application.dto.user;

import java.util.UUID;

public class UserDto {
  private UUID id;
  private String name;
  private String email;
  private String password;

  public UserDto(UUID id, String name, String email, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  
}
