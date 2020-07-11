package by.catalog.service;

import by.catalog.domain.Advert;
import by.catalog.storage.AdvertStorage;

import java.text.SimpleDateFormat;
import java.util.*;

public class AdvertService {

    private final AdvertStorage advertStorage = new AdvertStorage();

    public void saveAdvert(String mark, String model, String color, int year, double price, long idUser, String specificationAdvert) {
        AdvertStorage advertStorage = new AdvertStorage();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E dd.MM.yyyy ' время' hh:mm");
        String date = formatForDateNow.format(dateNow);
        advertStorage.addAdvert(new Advert(mark, model, color, year, price, idUser, date, specificationAdvert));
    }


    public Advert getAdvert(long idAdvert) {
        return advertStorage.returnAdvertById(idAdvert);
    }

    public Advert getAdvertByIdAdvertAndIdUser(long idAdvert, long idUser) {
        return advertStorage.returnAdvertByIdAdvertAndIdUser(idAdvert, idUser);
    }



    public void saveAdvertToUserAdvertList(long idAdvert, long idUser) {
        advertStorage.addIdUserIdAdvert(idUser, idAdvert);
    }

    public List<Advert> findAllInterestingAdverts(long idUser) {
        List<Advert> list = new ArrayList<>();
        List allIdAdvertByIdUser = advertStorage.getAllIdAdvertByIdUser(idUser);
        for (int i = 0; i < allIdAdvertByIdUser.size(); i++) {
            long idAdvert = (long) allIdAdvertByIdUser.get(i);
            Advert advert = advertStorage.returnAdvertById(idAdvert);
            list.add(advert);
        }
        return list;
    }


    public List<Advert> getLastAdvertsByColor(String color, int count, int page) {
        List<Advert> list = new ArrayList<>();
        List allAdverts = advertStorage.getAllAdvertsByColor(color);
        if (allAdverts != null) {
            for (int i = count * page - 1; i >= count * (page - 1) && i >= 0; i--) {
                if (i < allAdverts.size()) {
                    Advert advert = (Advert) allAdverts.get(i);
                    list.add(advert);
                }
            }
            Collections.reverse(list);
        }
        return list;
    }

    public List<Advert> getLastAdverts(int count, int page) {
        List<Advert> list = new ArrayList<>();
        List allAdverts = advertStorage.getAllAdverts();
        if (allAdverts != null) {
            for (int i = count * page - 1; i >= count * (page - 1) && i >= 0; i--) {
                if (i < allAdverts.size()) {
                    Advert advert = (Advert) allAdverts.get(i);
                    list.add(advert);
                }
            }
            Collections.reverse(list);
        }
        return list;
    }


    public List<Advert> findAdvertByMark(String mark, String color, int count, int page) {
        List<Advert> listBySearch = new ArrayList<>();
        List allAdverts = advertStorage.getAllAdverts();
        for (int i = 0; i < allAdverts.size(); i++) {
            Advert advert = (Advert) allAdverts.get(i);
            if (advert.getMarkCar().equals(mark)) {
                if (color.equals("anyColor")) {
                    listBySearch.add(advert);
                } else if (advert.getColorCar().equals(color)) {
                    listBySearch.add(advert);
                }
            }
        }
        List<Advert> newList = new ArrayList<>();
        for (int i = count * (page - 1); newList.size() < count && i < listBySearch.size(); i++) {
            if (!listBySearch.isEmpty()) {
                Advert advert = listBySearch.get(i);
                newList.add(advert);
            }
        }
        return newList;
    }

    public List<Advert> findAdvertByModel(String mark, String model, String color, int count, int page) {
        List<Advert> listBySearch = new ArrayList<>();
        List<Advert> modelByMark = advertStorage.getAllAdvertsByMark(mark);
        for (int i = 0; i < modelByMark.size(); i++) {
            Advert advert = (Advert) modelByMark.get(i);
            if (advert.getModelCar().equals(model)) {
                if (color.equals("anyColor")) {
                    listBySearch.add(advert);
                } else if (advert.getColorCar().equals(color)) {
                    listBySearch.add(advert);
                }
            }
        }

        List<Advert> newList = new ArrayList<>();
        for (int i = count * (page - 1); newList.size() < count && i < listBySearch.size(); i++) {
            if (!listBySearch.isEmpty()) {
                Advert advert = listBySearch.get(i);
                newList.add(advert);
            }
        }
        return newList;
    }

    public List<String> getAdvertMarks() {
        return advertStorage.getAllAdvertMark();
    }

    public List<String> returnModelByMark(String mark) {
        return advertStorage.getModelByMark(mark);
    }


    public List<String> returnMarkByModel(String model) {
        return advertStorage.getMarkByModel(model);
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


    public List<String> returnSortModel() {
        List<String> listModel = new ArrayList<>();
        boolean b = true;
        List<String> allModel = advertStorage.getAllModel();
        for (String mark : allModel) {
            for (String mark1 : listModel) {
                b = true;
                if (mark.equals(mark1)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                listModel.add(mark);
            }
        }
        return listModel;
    }


    public List<Advert> sortAllAdvertListByPrice(String sort, String color, int count, int page) {
        List<Advert> toSortList;
        if (color.equals("anyColor")) {
            toSortList = advertStorage.getAllAdverts();
        } else {
            toSortList = advertStorage.getAllAdvertsByColor(color);
        }
        toSortList.sort(Advert::compareTo);
        if (sort.equalsIgnoreCase("descPrice")) {
            Collections.reverse(toSortList);
        }
        List<Advert> newList = new ArrayList<>();
        for (int i = count * (page - 1); newList.size() < count && i < toSortList.size(); i++) {
            if (!toSortList.isEmpty()) {
                Advert advert = toSortList.get(i);
                newList.add(advert);
            }
        }
        return newList;
    }

    public List<Advert> sortAllAdvertListByYear(String sort, String color, int count, int page) {
        List<Advert> toSortList;
        if (color.equals("anyColor")) {
            toSortList = advertStorage.getAllAdverts();
        } else {
            toSortList = advertStorage.getAllAdvertsByColor(color);
        }
        toSortList.sort(new Advert());
        if (sort.equalsIgnoreCase("descYear")) {
            Collections.reverse(toSortList);
        }
        List<Advert> newList = new ArrayList<>();
        for (int i = count * (page - 1); newList.size() < count && i < toSortList.size(); i++) {
            if (!toSortList.isEmpty()) {
                Advert advert = toSortList.get(i);
                newList.add(advert);
            }
        }
        return newList;

    }

    public List<Advert> sortMarkAdvertListByPrice(String sort, String mark, String color, int count, int page) {
        List<Advert> toSortList;
        if (color.equals("anyColor")) {
            toSortList = advertStorage.getAllAdvertsByMark(mark);
        } else {
            toSortList = advertStorage.getAllAdvertsByMarkColor(mark, color);
        }
        toSortList.sort(Advert::compareTo);
        if (sort.equalsIgnoreCase("descPrice")) {
            Collections.reverse(toSortList);
        }
        List<Advert> newList = new ArrayList<>();
        for (int i = count * (page - 1); newList.size() < count && i < toSortList.size(); i++) {
            if (!toSortList.isEmpty()) {
                Advert advert = toSortList.get(i);
                newList.add(advert);
            }
        }
        return newList;
    }

    public List<Advert> sortMarkAdvertListByYear(String sort, String mark, String color, int count, int page) {
        List<Advert> toSortList;
        if (color.equals("anyColor")) {
            toSortList = advertStorage.getAllAdvertsByMark(mark);
        } else {
            toSortList = advertStorage.getAllAdvertsByMarkColor(mark, color);
        }
        toSortList.sort(new Advert());
        if (sort.equalsIgnoreCase("descYear")) {
            Collections.reverse(toSortList);
        }
        List<Advert> newList = new ArrayList<>();
        for (int i = count * (page - 1); newList.size() < count && i < toSortList.size(); i++) {
            if (!toSortList.isEmpty()) {
                Advert advert = toSortList.get(i);
                newList.add(advert);
            }
        }
        return newList;
    }

    public List<Advert> sortModelAdvertListByPrice(String sort, String model, String color, int count, int page) {
        List<Advert> toSortList;
        if (color.equals("anyColor")) {
            toSortList = advertStorage.getAllAdvertsByModel(model);
        } else {
            toSortList = advertStorage.getAllAdvertsByModelColor(model, color);
        }
        toSortList.sort(Advert::compareTo);
        if (sort.equalsIgnoreCase("descPrice")) {
            Collections.reverse(toSortList);
        }
        List<Advert> newList = new ArrayList<>();
        for (int i = count * (page - 1); newList.size() < count && i < toSortList.size(); i++) {
            if (!toSortList.isEmpty()) {
                Advert advert = toSortList.get(i);
                newList.add(advert);
            }
        }
        return newList;
    }

    public List<Advert> sortModelAdvertListByYear(String sort, String model, String color, int count, int page) {
        List<Advert> toSortList;
        if (color.equals("anyColor")) {
            toSortList = advertStorage.getAllAdvertsByModel(model);
        } else {
            toSortList = advertStorage.getAllAdvertsByModelColor(model, color);
        }
        toSortList.sort(new Advert());
        if (sort.equalsIgnoreCase("descYear")) {
            Collections.reverse(toSortList);
        }
        List<Advert> newList = new ArrayList<>();
        for (int i = count * (page - 1); newList.size() < count && i < toSortList.size(); i++) {
            if (!toSortList.isEmpty()) {
                Advert advert = toSortList.get(i);
                newList.add(advert);
            }
        }
        return newList;
    }


    public List<Integer> listYear() {
        List<Integer> listYear = new ArrayList<>();
        for (int i = 1980; i < 2021; i++) {
            listYear.add(i);
        }
        return listYear;
    }

    public String[] colorList() {
        return new String[]{"black", "white", "silver", "brown", "gray", "red", "blue"};
    }

    public void removeInterestingAdvert(long idAdvert, long idUser) {
        advertStorage.removeIdAdvertIdUser(idAdvert, idUser);
    }

    public boolean checkIntrAdvert(long idAdvert, long idUser) {
        return advertStorage.checkIdUserIdAdvert(idUser, idAdvert);
    }

    public boolean checkAdvertByUser(long idAdvert, long idUser) {
        Advert advert = advertStorage.returnAdvertById(idAdvert);
        return advert.getIdUser() == idUser;
    }

    public void destroyAdvertByIdAdvert(long idAdvert, long idUser) {
        advertStorage.removeAdvertByIdAdvert(idAdvert, idUser);
    }

    public void destroyAdvert(long idAdvert) {
        advertStorage.removeAdvert(idAdvert);
    }

    public void destroyUserAdvertList(long idAdvert) {
        advertStorage.removeAfterDestroyUserAdvertList(idAdvert);
    }

    public List<Advert> getAllUserAdvert(long idUser) {
        return advertStorage.getAllAdvertByIdUser(idUser);
    }

    public List<Advert> getAllAdvert() {
        return advertStorage.getAllAdverts();
    }

    public void editAdvertMarkAndModelByIdAdvert(long idAdvert, long idUser, String mark, String model) {
        advertStorage.updateMarkAndModelById(idAdvert, idUser, mark, model);
    }

    public void editAdvertMarkAndModel(long idAdvert, String mark, String model) {
        advertStorage.updateMarkAndModel(idAdvert, mark, model);
    }

    public void editColorByIdAdvert(long idAdvert, long idUser, String color) {
        advertStorage.updateColorById(idAdvert, idUser, color);
    }

    public void editColor(long idAdvert, String color) {
        advertStorage.updateColor(idAdvert, color);
    }

    public void editYearByIdAdvert(long idAdvert, long idUser, int year) {
        advertStorage.updateYearById(idAdvert, idUser, year);
    }

    public void editYear(long idAdvert, int year) {
        advertStorage.updateYear(idAdvert, year);
    }

    public void editPriceByIdAdvert(long idAdvert, long idUser, double price) {
        advertStorage.updatePriceById(idAdvert, idUser, price);
    }

    public void editPrice(long idAdvert, double price) {
        advertStorage.updatePrice(idAdvert, price);
    }

    public void editSpecificationByIdAdvert(long idAdvert, long idUser, String specification) {
        advertStorage.updateSpecificationById(idAdvert, idUser, specification);
    }

    public void editSpecification(long idAdvert, String specificationAdvert) {
        advertStorage.updateSpecification(idAdvert, specificationAdvert);
    }
}


