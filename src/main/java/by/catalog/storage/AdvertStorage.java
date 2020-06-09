package by.catalog.storage;

import by.catalog.domain.Advert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdvertStorage {

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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
                preparedStatement.setLong(5, advert.getId_user());
                preparedStatement.executeQuery();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Advert> findAllAdvertsByUser(String login) {
        return null;
    }
}