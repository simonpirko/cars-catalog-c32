package by.catalog.storage;


import by.catalog.domain.Advert;
import by.catalog.domain.Message;
import by.catalog.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "1987Roll";
    Connection connection = null;

    public void addUser(User user){
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into userscarcatalog (id, name, lastname, login, password, phone, role) values (default , ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public User getUserByLogin(String login) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from userscarcatalog s where s.login = ?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String password = resultSet.getString(5);
            String phone = resultSet.getString (6);
            String role = resultSet.getString(7);
            return new User(id, name, lastName, login, password, phone, role );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }





}
