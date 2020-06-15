package by.catalog.service;


import by.catalog.domain.User;
import by.catalog.storage.UserStorage;

public class UserService {

    private final UserStorage userStorage = new UserStorage();

    public User checkPasswordByLogin(String login, String password) {
        User userForCheck = userStorage.passwordByLogin(login);
        if (password.equals(userForCheck.getPassword())) {
            return userForCheck;
        } else return null;
    }

    public boolean checkUserByLogin(String login) {
        User userForCheck = userStorage.checkByLogin(login);
        return login.equals(userForCheck.getLogin());
    }

    public void updateUser(User user) {

    }
}
