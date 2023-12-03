package springboot.pp_3_1_3.service;



import springboot.pp_3_1_3.entity.Role;
import springboot.pp_3_1_3.entity.User;
import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> findAll();

    User findOne(int id);

    void saveUser(User user);

    void update(Long id, User updatedUser);

    void deleteUser(int id);

    Set<Role> getRole();
}
