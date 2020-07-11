package by.catalog.service;


import by.catalog.domain.Admin;
import by.catalog.domain.User;
import by.catalog.storage.UserStorage;

import java.util.List;

public class UserService {

    private final UserStorage userStorage = new UserStorage();

    public void saveUser(String name, String lastName, String login, String password, String phone, String role) {
        userStorage.addUser(new User(name, lastName, login, password, phone, role));
    }


    public User checkPasswordByLogin(String login, String password) {

        Admin admin = userStorage.getAdmin();
        if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
            return new User(null, null, login, password, null, null);
        }
        User userForCheck = userStorage.getUserByLogin(login);
        if (userForCheck == null) {
            return null;
        } else {
            if (password.equals(userForCheck.getPassword())) {
                return userForCheck;
            } else return null;
        }
    }

    public User returnUserById(Long id) {
        return userStorage.getUserById(id);
    }

    public boolean checkUserByLogin(String login) {
        return userStorage.checkByLogin(login);
    }

    public List<User> getAllUsers() {
        return userStorage.getAllUsers();
    }

    public void editUserById(User user) {
        userStorage.updateUserById(user.getId(), user);
    }

    public String authMessageService(String login, String password) {
        User user = userStorage.getUserByLogin(login);
        String message = null;
        if (user == null) {
            message = "User " + login + " not found";

        } else {
            if (!user.getPassword().equals(password)) {
                message = "Password not correct";

            }
        }
        return message;
    }
}
