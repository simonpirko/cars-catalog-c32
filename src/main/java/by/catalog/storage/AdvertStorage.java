package by.catalog.storage;

import by.catalog.domain.Advert;
import by.catalog.domain.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdvertStorage {

    Connection connection = null;
    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "1987Roll";

    public void addAdvert(Advert advert){

            try {
                connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into advert (id, model, color, yearcar, price, id_user) values (default , ? , ? , ? , ?, ?)");
                preparedStatement.setString(1, advert.getModelCar());
                preparedStatement.setString(2, advert.getColorCar());
                preparedStatement.setInt(3, advert.getYearCar());
                preparedStatement.setDouble(4, advert.getPriceCar());
                preparedStatement.setLong(5, advert.getIdUser());
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
            PreparedStatement preparedStatement = connection.prepareStatement( "select * from advert s where s.idadvert = ?");
            preparedStatement.setLong(1, idAdvert);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
             long id = resultSet.getLong(1);
             String model = resultSet.getString(2);
             String color = resultSet.getString(3);
             int yearCar = resultSet.getInt(4);
             double price = resultSet.getDouble(5);
             long idUser = resultSet.getLong(6);
             List<Message> messages = messageStorage.returnMessageByIdAdvert(idAdvert);
             return new Advert(id, model, color, yearCar, price, idUser, messages);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}