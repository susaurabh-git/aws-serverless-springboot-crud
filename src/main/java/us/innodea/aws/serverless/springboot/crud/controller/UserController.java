package us.innodea.aws.serverless.springboot.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import us.innodea.aws.serverless.springboot.crud.model.CreateUserRequest;
import us.innodea.aws.serverless.springboot.crud.model.User;

import java.util.*;

@Slf4j
@RestController
@EnableWebMvc
public class UserController {

    private static final String RESOURCE_PATH = "/users";
    private final Map<String, User> users = dummyUserRepo();

    @PostMapping(RESOURCE_PATH)
    public User createUser(@RequestBody CreateUserRequest request){
        log.info("Create User: {}", request);
        User user =createUserService(request);
        return user;
    }

    @GetMapping(RESOURCE_PATH)
    public List<User> getAllUsers(){
        log.info("Get All User!!");
        List<User> users =getAllUsersService();
        return users;
    }

    @GetMapping(RESOURCE_PATH+"/{id}")
    public User getUser(@PathVariable String id){
        log.info("Get User: {}", id);
        User user =getUserService(id);
        return user;
    }

    @DeleteMapping(RESOURCE_PATH+"/{id}")
    public User deleteUser(@PathVariable String id){
        log.info("delete User: {}", id);
        User user =deleteUserService(id);
        return user;
    }

    @PostMapping(RESOURCE_PATH+"/{id}")
    public User updateUser(@RequestBody CreateUserRequest request){
        log.info("Update User: {}", request);
        User user =updateUserService(request);
        return user;
    }

    private User createUserService(CreateUserRequest request) {
        User newUser =
                User.builder()
                        .id(UUID.randomUUID().toString())
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .build();
        users.put(newUser.getId(), newUser);
        return newUser;
    }

    private User getUserService(String id) {
        return users.get(id);
    }

    private List<User> getAllUsersService() {
        return new ArrayList<>(users.values());
    }

    private User deleteUserService(String id) {
        return users.remove(id);
    }

    private User updateUserService(CreateUserRequest request) {
        User updatedUser =
                User.builder()
                        .id(request.getId())
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .build();
        users.put(updatedUser.getId(), updatedUser);
        return updatedUser;
    }

    private Map<String, User> dummyUserRepo() {
        Map<String, User> users = new HashMap<>();
        String id = UUID.randomUUID().toString();
        users.put(id, User.builder().id(id).firstName("Amie").lastName("Apple").build());
        id = UUID.randomUUID().toString();
        users.put(id, User.builder().id(id).firstName("Bouncy").lastName("Ben").build());
        id = UUID.randomUUID().toString();
        users.put(id, User.builder().id(id).firstName("Clever").lastName("Cat").build());
        id = UUID.randomUUID().toString();
        users.put(id, User.builder().id(id).firstName("Dippy").lastName("Duck").build());
        return users;
    }

}

