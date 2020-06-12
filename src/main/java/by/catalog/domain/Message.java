package by.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message {

    long id;
    long idAdvert;
    long idUser;
    String body;
    String  date;

    public Message(long idAdvert, long idUser, String body, String date) {
        this.idAdvert = idAdvert;
        this.idUser = idUser;
        this.body = body;
        this.date = date;
    }

}
