package by.catalog.service;

import by.catalog.domain.Advert;
import by.catalog.domain.User;
import by.catalog.storage.AdvertStorage;

import javax.swing.*;
import java.util.List;

public class AdvertService {
    public void saveAdvert (String madel, String color, int year, double price, User user, List <String> message){
        AdvertStorage advertStorage = new AdvertStorage();
        advertStorage.addAdvert(new Advert(madel, color, year, price, user, message));
    }
}
