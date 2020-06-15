package by.catalog.service;


import by.catalog.domain.User;
import by.catalog.storage.UserStorage;

public class UserService {

    private final UserStorage userStorage = new UserStorage();

    public void saveUser (String name, String lastName, String login, String password, String phone, String role){
        userStorage.addUser(new User(name, lastName, login, password, phone, role));
    }


    public User checkPasswordByLogin(String login, String password) {
        User userForCheck = userStorage.getUserByLogin(login);
        if (password.equals(userForCheck.getPassword())) {
            return userForCheck;
        } else return null;
    }


    public void updateUser(User user) {

    }
}
