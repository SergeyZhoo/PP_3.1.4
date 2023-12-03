package springboot.pp_3_1_3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.pp_3_1_3.entity.Role;
import springboot.pp_3_1_3.entity.User;
import springboot.pp_3_1_3.repository.RoleRepository;
import springboot.pp_3_1_3.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        return userRepository.findById((long) id).orElse(null);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user);
        if (user.getRoles().contains(roleRepository.findRoleByName("ROLE_ADMIN"))) {
            user.getRoles().add(roleRepository.findRoleByName("ROLE_USER"));
        }
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(Long id, User updatedUser) {
        updatedUser.setId(id);
        updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        if (updatedUser.getRoles().contains(roleRepository.findRoleByName("ROLE_ADMIN"))) {
            updatedUser.getRoles().add(roleRepository.findRoleByName("ROLE_USER"));
        }
        userRepository.save(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteById((long) id);
    }

    @Override
    public Set<Role> getRole() {
        return new HashSet<>(roleRepository.findAll());
    }
}