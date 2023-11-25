package springboot.pp_3_1_3.service;


import org.springframework.stereotype.Service;
import springboot.pp_3_1_3.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User findByUsername(String username);
}
