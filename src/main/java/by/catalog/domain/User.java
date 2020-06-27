package by.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    private long id;
    private final String name;
    private final String lastName;
    private final String login;
    private final String password;
    private final String phone;
    private final String role;

    public User(String name, String lastName, String login, String password, String phone, String role) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }
}