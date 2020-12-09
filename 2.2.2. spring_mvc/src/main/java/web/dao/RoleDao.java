package web.dao;

import web.model.Role;

import java.util.Set;

public interface RoleDao {
    void newRole(Set<Role> roles);
    Set<Role> getRole();
}

