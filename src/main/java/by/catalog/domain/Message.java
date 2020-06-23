package by.catalog.domain;

import by.catalog.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message {

    private long id;
    private long idAdvert;
    private long idUser;
    private String body;
    private String date;

    public Message(long idAdvert, long idUser, String body, String date) {
        this.idAdvert = idAdvert;
        this.idUser = idUser;
        this.body = body;
        this.date = date;
    }

    @Override
    public String toString() {

        UserService userService = new UserService();
        User user = userService.returnUserById(idUser);

        return user.getName() + " date " + date + " Text " + body;
    }
}
