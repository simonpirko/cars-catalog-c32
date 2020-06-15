package by.catalog.domain;

import by.catalog.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message {

    long id;
    long idAdvert;
    long idUser;
    String body;
    String date;

    public Message(long idAdvert, long idUser, String body, String date) {
        this.idAdvert = idAdvert;
        this.idUser = idUser;
        this.body = body;
        this.date = date;
    }

    @Override
    public String toString() {
        UserService userService = new UserService();
        return userService.returnUserById(idUser).name + " / " + date + " / " + body;
    }
}
