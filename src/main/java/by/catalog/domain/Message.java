package by.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message {

    private long id;
    private final long idAdvert;
    private long idUser;
    private String nameUser;
    private final String body;
    private final String date;

    public Message(long idAdvert, long idUser, String body, String date) {
        this.idAdvert = idAdvert;
        this.idUser = idUser;
        this.body = body;
        this.date = date;
    }

    public Message(long id, long idAdvert, String nameUser, String body, String date) {
        this.id = id;
        this.idAdvert = idAdvert;
        this.nameUser = nameUser;
        this.body = body;
        this.date = date;
    }

    public Message(long id, long idAdvert, long idUser, String body, String date) {
        this.id = id;
        this.idAdvert = idAdvert;
        this.idUser = idUser;
        this.body = body;
        this.date = date;
    }

}
