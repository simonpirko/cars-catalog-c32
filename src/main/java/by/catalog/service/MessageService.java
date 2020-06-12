package by.catalog.service;

import by.catalog.domain.Message;
import by.catalog.storage.MessageStorage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MessageService {
    private MessageStorage messageStorage = new MessageStorage();

    public void saveMessage ( long idAdvert, long idUser, String body){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E yyyy.MM.dd 'время' HH:mm:ss");
        simpleDateFormat.format(date);
        String strDate = simpleDateFormat.format(date).toString();
        messageStorage.addMessage(new Message(idAdvert, idUser, body, strDate));
    }

    public List<Message> getMessage(long idAdvert){

        return messageStorage.returnMessageByIdAdvert(idAdvert);
    }
}
