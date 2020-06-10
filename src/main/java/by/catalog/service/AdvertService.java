package by.catalog.service;

import by.catalog.domain.Advert;
import by.catalog.domain.User;
import by.catalog.storage.AdvertStorage;

import javax.swing.*;
import java.util.List;

public class AdvertService {
    public void saveAdvert (String model, String color, int year, double price, long iduser){
        AdvertStorage advertStorage = new AdvertStorage();
        advertStorage.addAdvert(new Advert(model, color, year, price, iduser));
    }
}
