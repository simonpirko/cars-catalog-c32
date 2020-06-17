package by.catalog.service;

import by.catalog.domain.Advert;
import by.catalog.domain.Message;
import by.catalog.storage.AdvertStorage;

import java.util.ArrayList;
import java.util.List;

public class AdvertService {

    AdvertStorage advertStorage = new AdvertStorage();

    public void saveAdvert(String model, String color, int year, double price, long idUser) {
        AdvertStorage advertStorage = new AdvertStorage();
        advertStorage.addAdvert(new Advert(model, color, year, price, idUser));
    }



    public Advert getAdvert(long idAdvert) {
        return advertStorage.returnAdvertById(idAdvert);
    }



    public void saveAdvertToUserAdvertList(Advert advert, long idUser) {
        advertStorage.addIdUserIdAdvert(idUser, advert.getId());
        // FIXME: 6/13/20
    }

    public List<Advert> findAllAdvertsFromUser ( long idUser) {
        List<Advert> list = new ArrayList<>();
        List allIdAdvertByIdUser = advertStorage.getAllIdAdvertByIdUser(idUser);
        for (int i = 0; i < allIdAdvertByIdUser.size(); i++) {
            long idAdvert = (long) allIdAdvertByIdUser.get(i);
            Advert advert = advertStorage.returnAdvertById(idAdvert);
            list.add(advert);
        }
        return list;
    }

    public List<Advert> findAllAdverts () {
//        return advertStorage.findAllAdverts();
        // FIXME: 6/13/20
        return null;
    }



    public Advert findAdvertById(long advertId) {
//        advertStorage.findAdvertById(advertId);
        // FIXME: 6/13/20 
        return null;
    }





}
