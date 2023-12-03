package springboot.pp_3_1_3.service;


import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.pp_3_1_3.entity.User;
import springboot.pp_3_1_3.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(getEncodedPassword(user));
        userRepository.save(user);
    }

    private String getEncodedPassword(User user) {
        return passwordEncoder.encode(user.getPassword());
    }

    @Override
    public void updateUser(User user) {
        if (user.getPassword().isEmpty()) {
            user.setPassword(userRepository.getById(user.getId()).getPassword());
        } else {
            user.setPassword(getEncodedPassword(user));
        }
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }
}