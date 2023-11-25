package springboot.pp_3_1_3.service;

import org.springframework.stereotype.Service;
import springboot.pp_3_1_3.entity.Role;

import javax.transaction.Transactional;
import java.util.List;


public interface RoleService {
    Role findRoleById(Long id);

    List<Role> getRoles();

//    List<Role> getUniqueAllRoles();

    void addRole(Role role);
}
