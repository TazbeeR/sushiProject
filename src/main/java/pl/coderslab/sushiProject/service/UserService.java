package pl.coderslab.sushiProject.service;

import pl.coderslab.sushiProject.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    Optional<User> getUser(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);
}
