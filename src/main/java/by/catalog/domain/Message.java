package by.catalog.domain;

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
        return "Message{" +

                ", body='" + body + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
