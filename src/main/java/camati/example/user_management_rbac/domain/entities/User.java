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

  public User(String name, String email, String password,
      Set<Role> roles) {

    this.name = name;
    this.email = email;
    this.password = password;

    this.roles = roles;
  };

  public void addRole(Role role) {
    this.roles.add(role);
  }

  public void removeRole(Role role) {
    this.roles.remove(role);
  }

  public void updatePassword(String newPassword) {
    this.password = newPassword;
    this.updatedAt = LocalDateTime.now();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

}