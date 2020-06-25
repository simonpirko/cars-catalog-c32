package by.catalog.storage;

import by.catalog.domain.Advert;
import by.catalog.domain.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdvertStorage {

    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "1987Roll";
    Connection connection = null;

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addAdvert(Advert advert) {

        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into advert (id, model, color, yearcar, price, id_user, dateadvert, specificationadvert) values (default , ? , ? , ? , ?, ?, ?, ?)");
            preparedStatement.setString(1, advert.getModelCar());
            preparedStatement.setString(2, advert.getColorCar());
            preparedStatement.setInt(3, advert.getYearCar());
            preparedStatement.setDouble(4, advert.getPriceCar());
            preparedStatement.setLong(5, advert.getIdUser());
            preparedStatement.setString(6, advert.getDateAdvert());
            preparedStatement.setString(7, advert.getSpecificationAdvert());
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Advert returnAdvertById(long idAdvert) {
        MessageStorage messageStorage = new MessageStorage();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert s where s.id = ?");
            preparedStatement.setLong(1, idAdvert);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long id = resultSet.getLong(1);
            String model = resultSet.getString(2);
            String color = resultSet.getString(3);
            int yearCar = resultSet.getInt(4);
            double price = resultSet.getDouble(5);
            long idUser = resultSet.getLong(6);
            String date = resultSet.getString(7);
            String specification = resultSet.getString(8);
            List<Message> messages = messageStorage.returnMessageByIdAdvert(idAdvert);
            return new Advert(id, model, color, yearCar, price, idUser, date, specification, messages);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addIdUserIdAdvert(long idUser, long idAdvert) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into useradvertlist (iduser, idadvert) values (?, ?)");
            preparedStatement.setLong(1, idUser);
            preparedStatement.setLong(2, idAdvert);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List getAllIdAdvertByIdUser(long idUser) {
        ArrayList<Long> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from useradvertlist s where s.iduser = ?");
            preparedStatement.setLong(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idAdvert = resultSet.getLong(2);
                list.add(idAdvert);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Advert> getAllAdverts() {
        List<Advert> list = new ArrayList<>();
        try {
            long id = 0;
            String model = "";
            String color = "";
            int year = 0;
            double price = 0;
            long idUser = 0;
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong(1);
                model = resultSet.getString(2);
                color = resultSet.getString(3);
                year = resultSet.getInt(4);
                price = resultSet.getDouble(5);
                idUser = resultSet.getLong(6);
                Advert advert = new Advert(id, model, color, year, price, idUser);
                list.add(advert);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getModelByMark(String mark) {
        ArrayList<String> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car s where s.mark = ?");
            preparedStatement.setString(1, mark);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String model = resultSet.getString(2);
                list.add(model);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllMark() {
        ArrayList<String> listMark = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String mark = resultSet.getString(1);
                listMark.add(mark);
            }
            return listMark;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}