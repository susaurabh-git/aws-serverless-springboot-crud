package us.innodea.aws.springboot.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import us.innodea.aws.springboot.crud.model.CreateUserRequest;
import us.innodea.aws.springboot.crud.model.User;
import us.innodea.aws.springboot.crud.service.UserService;

import java.util.*;

@Slf4j
@RestController
@EnableWebMvc
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserRequest request){
        log.info("Create User: {}", request);
        User user =userService.createUser(request);
        return user;
    }

    @GetMapping
    public List<User> getAllUsers(){
        log.info("Get All User!!");
        List<User> users =userService.getAllUsers();
        return users;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        log.info("Get User: {}", id);
        User user = userService.getUser(id);
        return user;
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable String id){
        log.info("delete User: {}", id);
        User user = userService.deleteUser(id);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody CreateUserRequest request){
        log.info("Update User: {}", request);
        User user = userService.updateUser(request);
        return user;
    }

}

