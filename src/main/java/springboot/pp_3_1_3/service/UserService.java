package springboot.pp_3_1_3.service;


import springboot.pp_3_1_3.entity.User;

import java.util.List;

    public interface UserService {
        List<User> findAllUsers();

        void saveUser(User user);

        void updateUser(User updatedUser);

        void deleteById(Long id);

        User findByUsername(String username);

        User getById(Long id);
    }