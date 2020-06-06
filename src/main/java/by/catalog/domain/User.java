package by.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    long id;
    String name;
    String lastName;
    String login;
    String password;
    String phone;
    String role;
    List <Advert> car;
}
