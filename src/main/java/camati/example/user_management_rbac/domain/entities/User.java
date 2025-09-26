package camati.example.user_management_rbac.domain.entities;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class User {

  private UUID id;
  private String name;
  private String email;
  private String password;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private Set<Role> roles;

  public User() {
  }

  public User(String name, String email, String password, LocalDateTime createdAt,
      Set<Role> roles) {

    this.name = name;
    this.email = email;
    this.password = password;
    this.createdAt = createdAt;

    this.roles = roles;
  };

  public void addRole(Role role ){
    this.roles.add(role);
  }
  public void removeRole(Role role ){
    this.roles.remove(role);
  }

  public void updatePassword(String newPassword) {
    this.password = newPassword;
    this.updatedAt = LocalDateTime.now();
  }

}