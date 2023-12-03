package springboot.pp_3_1_3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.pp_3_1_3.entity.Role;
import springboot.pp_3_1_3.entity.User;
import springboot.pp_3_1_3.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void setUserRoles(User user){
        user.setRoles(user.getRoles().stream()
                .map(this::getRole).collect(Collectors.toSet()));
    }

    @Override
    public Role getRole(Role role){
        return roleRepository.getById(role.getId());
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
