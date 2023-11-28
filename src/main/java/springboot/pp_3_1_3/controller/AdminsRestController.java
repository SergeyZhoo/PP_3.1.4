package springboot.pp_3_1_3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.pp_3_1_3.entity.User;
import springboot.pp_3_1_3.service.RoleService;
import springboot.pp_3_1_3.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminsRestController {
    private final UserService userService;
    private final RoleService roleService;


    public AdminsRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsersList() {
        System.out.println("Приложение начало работу метода getUsersList");
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Приложение начало работу метода getUser");
        User user = userService.getById(id);
        System.out.println(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("Приложение начало работу метода createUser");
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        System.out.println("Приложение начало работу метода saveUser");
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        System.out.println("Приложение начало работу метода deleteUser");
        String username = userService.getById(id).getUsername();
        userService.deleteById(id);
        return new ResponseEntity<>(username, HttpStatus.ACCEPTED);
    }
}