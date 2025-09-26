package camati.example.user_management_rbac.domain.entities;

import java.util.Set;

public class Role {

  private String id;
  private String name;
  private String description;

  private Set<Permission> permissions;

  public Role(String name, Set<Permission> permissions) {

    this.name = name;
    this.permissions = permissions;
  }

  public void addPermission(Permission permission) {
    this.permissions.add(permission);
  }

  public void removePermission(Permission permission) {
    this.permissions.remove(permission);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Set<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(Set<Permission> permissions) {
    this.permissions = permissions;
  }

  
}
