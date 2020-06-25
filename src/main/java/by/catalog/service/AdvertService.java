package by.catalog.service;

import by.catalog.domain.Advert;
import by.catalog.storage.AdvertStorage;

import java.util.ArrayList;
import java.util.List;

public class AdvertService {

    private final AdvertStorage advertStorage = new AdvertStorage();

    public void saveAdvert(String model, String color, int year, double price, long idUser) {
        AdvertStorage advertStorage = new AdvertStorage();
        advertStorage.addAdvert(new Advert(model, color, year, price, idUser));
    }


    public Advert getAdvert(long idAdvert) {
        return advertStorage.returnAdvertById(idAdvert);
    }


    public void saveAdvertToUserAdvertList(long idAdvert, long idUser) {
        advertStorage.addIdUserIdAdvert(idUser, idAdvert);
        // FIXME: 6/13/20
    }

    public List<Advert> findAllAdvertsFromUser(long idUser) {
        List<Advert> list = new ArrayList<>();
        List allIdAdvertByIdUser = advertStorage.getAllIdAdvertByIdUser(idUser);
        for (int i = 0; i < allIdAdvertByIdUser.size(); i++) {
            long idAdvert = (long) allIdAdvertByIdUser.get(i);
            Advert advert = advertStorage.returnAdvertById(idAdvert);
            list.add(advert);
        }
        return list;
    }

    public List<Advert> findAllAdverts() {
//        return advertStorage.findAllAdverts();
        // FIXME: 6/13/20
        return null;
    }

    public List<Advert> getLastAdverts() {
        List<Advert> list = new ArrayList<>();
        List allAdverts = advertStorage.getAllAdverts();
        for (int i = allAdverts.size() - 1; i > allAdverts.size() - 20 && i > -1; i--) {
            Advert advert = (Advert) allAdverts.get(i);

            list.add(advert);
        }
        return list;
    }


    public Advert findAdvertById(long advertId) {
//        advertStorage.findAdvertById(advertId);
        // FIXME: 6/13/20 
        return null;
    }

    public List<String> returnModelByMark(String mark) {
        return advertStorage.getModelByMark(mark);
    }

    public List<String> returnSortMark() {
        List<String> listMark = new ArrayList<>();
        boolean b = true;
        List<String> allMark = advertStorage.getAllMark();
        for (String mark : allMark) {
            for (String mark1 : listMark) {
                b = true;
                if (mark.equals(mark1)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                listMark.add(mark);
            }
        }
        return listMark;
    }

    public List<Integer> listYear() {
        List<Integer> listYear = new ArrayList<>();
        for (int i = 1980; i < 2021; i++) {
            listYear.add(i);
        }
        return listYear;
    }


}
