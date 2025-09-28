package camati.example.user_management_rbac.application.dto.user;

import java.util.UUID;

public class UpdateUserResponseDto {
  private UUID id;
  private String name;
  private String email;

  public UpdateUserResponseDto() {
  }

  public UpdateUserResponseDto(UUID id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  
}
