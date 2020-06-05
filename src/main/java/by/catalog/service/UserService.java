package by.catalog.service;


import by.catalog.domain.User;
import by.catalog.storage.UserStorage;

public class UserService {

    private UserStorage userStorage = new UserStorage();

    public User checkPasswordByLogin(String login, String password){
       User userForCheck = userStorage.passwordByLogin(login);
        if (password.equals(userForCheck.getPassword())) {
            return userForCheck;
        }
        else return null;
    }
}
