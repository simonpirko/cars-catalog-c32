package by.catalog.service;

import by.catalog.domain.Advert;
import by.catalog.domain.Message;
import by.catalog.domain.User;
import by.catalog.storage.AdvertStorage;
import by.catalog.storage.UserStorage;

import java.util.List;

public class AdvertService {

    AdvertStorage advertStorage = new AdvertStorage();

    public void saveAdvert(String model, String color, int year, double price, long idUser, List<Message> message) {
        advertStorage.addAdvert(new Advert(model, color, year, price, idUser, message));
    }

    public Advert getAdvert(long idAdvert) {
        return advertStorage.returnAdvertById(idAdvert);
    }

    public String getModelFromAdvert(long idAdvert){
        Advert advert = advertStorage.returnAdvertById(idAdvert);
        return advert.getModelCar();
    }

    public String getColorFromAdvert(long idAdvert){
        Advert advert = advertStorage.returnAdvertById(idAdvert);
        return advert.getColorCar();
    }
    public int getYearFromAdvert(long idAdvert){
        Advert advert = advertStorage.returnAdvertById(idAdvert);
        return advert.getYearCar();
    }
    public double getPriceFromAdvert(long idAdvert){
        Advert advert = advertStorage.returnAdvertById(idAdvert);
        return advert.getPriceCar();
    }
    public String getUserNameFromAdvert (long idAdvert){
        Advert advert = advertStorage.returnAdvertById(idAdvert);
        long idUser = advert.getIdUser();
        UserStorage userStorage = new UserStorage();
        User userById = userStorage.getUserById(idUser);
        return userById.getName();
    }

    public String getUserLastNameFromAdvert (long idAdvert){
        Advert advert = advertStorage.returnAdvertById(idAdvert);
        long idUser = advert.getIdUser();
        UserStorage userStorage = new UserStorage();
        User userById = userStorage.getUserById(idUser);
        return userById.getLastName();
    }

    public String getUserPhoneFromAdvert (long idAdvert){
        Advert advert = advertStorage.returnAdvertById(idAdvert);
        long idUser = advert.getIdUser();
        UserStorage userStorage = new UserStorage();
        User userById = userStorage.getUserById(idUser);
        return userById.getPhone();
    }

    public List getUserMessagesFromAdvert (long idAdvert){
        Advert advert = advertStorage.returnAdvertById(idAdvert);
        return advert.getMessage();
    }

    public void saveAdvertToUserAdvertList(long idAdvert, long idUser) {
//        advertStorage.addAdvertToUserAdvertList(advertId, userId);
        // FIXME: 6/13/20
    }

    public Advert findAdvertById(long idAdvert) {
//        advertStorage.findAdvertById(advertId);
        // FIXME: 6/13/20 
        return null;
    }

    public void saveAdvert(String model, String color, int year, double price, long idUser) {
        AdvertStorage advertStorage = new AdvertStorage();
        advertStorage.addAdvert(new Advert(model, color, year, price, idUser));
    }

    public List<Advert> findAllAdverts() {
//        return advertStorage.findAllAdverts();
        // FIXME: 6/13/20 
        return null;
    }

    public void makeChangesInAdvert (long idAdvert, String newModel, String newColor, String newYear, String newPrice,  String newDescription) {
        Advert advertForChange = findAdvertById(idAdvert);
        if (newModel != null) {
            advertForChange.setModelCar(newModel);
        }
        if (newColor != null) {
            advertForChange.setModelCar(newColor);
        }
        if (newYear != null) {
            advertForChange.setModelCar(newYear);
        }
        if (newPrice != null) {
            advertForChange.setModelCar(newPrice);
        }
        if (newDescription != null) {
            advertForChange.setModelCar(newDescription);
        }
    }

}
