package by.catalog.service;

import by.catalog.domain.Message;
import by.catalog.storage.MessageStorage;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MessageService {
    MessageStorage messageStorage = new MessageStorage();

    public void saveMessage(long idAdvert, long idUser, String body) {
        Calendar calendar = new GregorianCalendar();
        String date = calendar.getTime().toString();
        messageStorage.addMessage(new Message(idAdvert, idUser, body, date));
    }

    public List<Message> getMessage(long idAdvert) {

        return messageStorage.returnMessageByIdAdvert(idAdvert);
    }
}
