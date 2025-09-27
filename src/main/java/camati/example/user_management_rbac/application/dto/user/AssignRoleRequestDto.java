package camati.example.user_management_rbac.application.dto.user;

import java.util.UUID;

public class AssignRoleRequestDto {
  private UUID userId;
  private String roleName;
  public UUID getUserId() {
    return userId;
  }
  public void setUserId(UUID userId) {
    this.userId = userId;
  }
  public String getRoleName() {
    return roleName;
  }
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  

}
