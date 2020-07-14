package by.catalog.storage;


import by.catalog.domain.Admin;
import by.catalog.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private Connection connection = null;

    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "";
    private final static String PASS_TABLES = "";

    private final static String UPDATE_USER_BY_ID = "update userscarcatalog set name = ?, lastname = ?, login = ?, password = ?, phone= ? where id = ?";
    private final static String CHECK_BY_LOGIN = "select * from userscarcatalog s where s.login = ?";
    private final static String GET_USER_BY_ID = "select * from userscarcatalog s where s.id = ?";
    private final static String GET_USER_BY_LOGIN = "select * from userscarcatalog s where s.login = ?";
    private final static String ADD_USER = "insert into userscarcatalog (id, name, lastname, login, password, phone, role) values (default , ?, ?, ?, ?, ?, ?)";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
    public void addUser(User user) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER);
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
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String password = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String role = resultSet.getString(7);
            connection.close();
            return new User(id, name, lastName, login, password, phone, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(long id) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String login = resultSet.getString(4);
            String password = resultSet.getString(5);
            String phone = resultSet.getString(6);
            String role = resultSet.getString(7);
            connection.close();
            return new User(id, name, lastName, login, password, phone, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from userscarcatalog");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String login = resultSet.getString(4);
                String password = resultSet.getString(5);
                String phone = resultSet.getString(6);
                User user = new User(id, name, lastName, login, password, phone);
                list.add(user);
            }
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean checkByLogin(String login) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void removeUser(long idAdvert) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from userscarcatalog where id = ? ");
            preparedStatement.setLong(1, idAdvert);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserById(long id, User user) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
