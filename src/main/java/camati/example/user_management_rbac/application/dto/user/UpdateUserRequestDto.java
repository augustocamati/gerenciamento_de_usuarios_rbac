package camati.example.user_management_rbac.application.dto.user;


public class UpdateUserRequestDto {

  private String name;

  private String email;

  private String password;

  public UpdateUserRequestDto() {
  }

  public UpdateUserRequestDto(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  
}
