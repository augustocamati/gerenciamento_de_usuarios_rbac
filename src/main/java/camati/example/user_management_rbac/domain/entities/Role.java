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
}
