package com.example.weather.SQL;

import java.sql.*;

public class ExampleJdbcConnection {

    private final String URL = "jdbc:mysql://localhost:3306/weatherdb";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";


    private Connection connection;

    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Подключение с бд не установлено" + e);
        }
    }

    /**
     * Добавить
     */
    public void insertUser() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into users (name,age,email) values('Steve', 55, 'asdf@mail.com')");
            System.out.println("Добавлен");
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при добавлении " + e);
        }
    }

    /**
     * Добавить
     */
    public void insertSomeUser() {
        try {
            Statement statement = connection.createStatement();
            statement.addBatch("insert into users (name,age,email) values('AO', 21, 'asdfdf@mail.com')");
            statement.addBatch("insert into users (name,age,email) values('Kevin', 55, 'asdsff@mail.com')");
            statement.addBatch("insert into users (name,age,email) values('Buffalo', 12, 'adsfsdf@mail.com')");
            statement.executeBatch();

//            statement.clearBatch(); для отчистки batch
            System.out.println("Добавлены");
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при добавлении " + e);
        }
    }

    /**
     * изменить
     */
    public void updateData() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update users set name = 'Steve', age=30 where id = 8;");
            System.out.println("Изменен");
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при изменении " + e);
        }
    }

    /**
     * Получить результат
     * @return
     */
    public ResultSet getResultset() {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) connection.createStatement();
            return statement.executeQuery("SELECT * FROM users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Отобразить всех пользователей
     */
    public void showAllUsers() {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                System.out.println(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Закрыть соединение
     */
    public void closeConnection() {
        try {
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД разорвано");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Вы еще не соединены с БД" + e);
        }
    }

    public Connection getConnection() {
        return connection;
    }


}



