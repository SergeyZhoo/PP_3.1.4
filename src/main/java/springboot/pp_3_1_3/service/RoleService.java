package springboot.pp_3_1_3.service;

import springboot.pp_3_1_3.entity.Role;
import springboot.pp_3_1_3.entity.User;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    void setUserRoles(User user);

    Role getRole(Role role);

    Role findByName(String name);
}