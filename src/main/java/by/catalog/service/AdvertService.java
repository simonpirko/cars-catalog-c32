package by.catalog.service;

import by.catalog.domain.Advert;
import by.catalog.domain.User;
import by.catalog.storage.AdvertStorage;

import javax.swing.*;
import java.util.List;

public class AdvertService {

    AdvertStorage advertStorage = new AdvertStorage();

    public void saveAdvert (String model, String color, int year, double price, int idUser, List <String> message){
        advertStorage.addAdvert(new Advert(model, color, year, price, idUser, message));
    }

    public void saveAdvertToUserAdvertList (Advert advert, int userId) {
        advertStorage.addAdvertToUserAdvertList(advert, userId);

    }

    public Advert findAdvertById (int advertId) {
        advertStorage.findAdvertById(advertId);
        return null;
    }

    public void addMessageToAdvertById (int advertId, String addMessage) {
        advertStorage.addMessageToAdvertById(advertId, addMessage);
    }

    public List<Advert> findAllAdverts () {
        return advertStorage.findAllAdverts();
    }

}
