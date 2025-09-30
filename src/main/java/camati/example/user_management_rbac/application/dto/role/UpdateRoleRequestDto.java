package camati.example.user_management_rbac.application.dto.role;


public class UpdateRoleRequestDto {

  private String name;

  private String description;

  

 

  public UpdateRoleRequestDto(String name, String description) {
    this.name = name;
    this.description = description;
  
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
