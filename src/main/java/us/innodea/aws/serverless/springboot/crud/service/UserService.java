package us.innodea.aws.serverless.springboot.crud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import us.innodea.aws.serverless.springboot.crud.model.CreateUserRequest;
import us.innodea.aws.serverless.springboot.crud.model.User;

import java.util.*;
@Slf4j
@Service
public class UserService {

  private final Map<String, User> users = dummyUserRepo();

  public User createUser(CreateUserRequest request) {
    User newUser =
        User.builder()
            .id(UUID.randomUUID().toString())
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .build();
    users.put(newUser.getId(), newUser);
    return newUser;
  }

  public User getUser(String id) {
    return users.get(id);
  }

  public List<User> getAllUsers() {
    return new ArrayList<>(users.values());
  }

  public User deleteUser(String id) {
    return users.remove(id);
  }

  public User updateUser(CreateUserRequest request) {
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
