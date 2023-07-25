package by.pvt.servlets;

import by.pvt.servlets.domain.Role;
import by.pvt.servlets.domain.User;
import by.pvt.servlets.service.impl.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        App.init();
    }

    public static void init() {
        User user1 = new User(1L, "Anton", "Sitkov", "Rex", "1234", Role.CLIENT);
        User user2 = new User(2L, "John", "Davis", "Lux", "1331", Role.CLIENT);
        List<User> users = new ArrayList<>();
        users.add(user1);
        FileWorker.serializeObject(users, UserRepositoryImpl.FILE);
        FileWorker.deserializeObject(UserRepositoryImpl.FILE);

        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        System.out.println(userRepository.getAllUsers());
        userRepository.addUser(user2);
        System.out.println(userRepository.getAllUsers());
        System.out.println(userRepository.getUserById(user2.getId()));
        userRepository.deleteUser(user1.getId());
    }
}
