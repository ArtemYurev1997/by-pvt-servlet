package by.pvt.servlets.service;

import by.pvt.servlets.domain.User;

import java.util.List;

public interface UserRepository {
    User addUser(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);

    User getUserById(Long id);
}
