package pl.coderslab.sushiProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.sushiProject.entity.User;
import pl.coderslab.sushiProject.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JPAUserService implements UserService{
    private final UserRepository userRepository;
    @Autowired

    public JPAUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
