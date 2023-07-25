package by.pvt.servlets.service.impl;

import by.pvt.servlets.FileWorker;
import by.pvt.servlets.domain.User;
import by.pvt.servlets.service.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl extends FileWorker implements UserRepository {
    public static List<User> users = new ArrayList<>();

    public static String FILE = "D:\\Project Maven\\Common Shop\\by-pvt-project\\src\\main\\resources\\dbFile";

    @Override
    public User addUser(User user) {
        users = getAllUsers();
        users.add(user);
        serializeObject(users, FILE);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Object object = deserializeObject(FILE);
        List<User> user = new ArrayList<>();
        if (object instanceof List<?>) {
            user = (List<User>) object;
        }
        return user;
    }


    @Override
    public void deleteUser(Long id) {
        users = getAllUsers();
        if(users.isEmpty()) {
            return;
        }
        User user = getUserById(id);
        users.remove(user);
        serializeObject(users, FILE);
        System.out.println(users);
    }

    @Override
    public User getUserById( Long id) {
        users = getAllUsers();
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
}
