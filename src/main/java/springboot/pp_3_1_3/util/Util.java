package springboot.pp_3_1_3.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springboot.pp_3_1_3.entity.Role;
import springboot.pp_3_1_3.entity.User;
import springboot.pp_3_1_3.repository.RoleRepository;
import springboot.pp_3_1_3.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class Util implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public Util(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void run(String[] args) {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> adminRoles = new HashSet<>();
        Set<Role> userRoles = new HashSet<>();
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
        adminRoles.add(roleAdmin);
        userRoles.add(roleUser);

        User userAdmin = new User("Admin", "Admin", (byte) 13, "admin", "$2a$12$M2nesl.f4c2YXOiWnHvR4Opk3UjJHeFnIHiyizfnfAuMhkG8QX25q", adminRoles);
        User userUser = new User("User", "User", (byte) 25, "user", "$2a$12$/5c/g2pbdwF3f8lxyFMQuOJ3tZYGTlBSsaovDZzp4h7sM1mQroZFm", userRoles);

        System.out.println(userAdmin);
        userRepository.save(userAdmin);
        System.out.println(userUser);
        userRepository.save(userUser);

        System.out.println(userAdmin.getRoles());
        System.out.println(userUser.getRoles());
    }
}
