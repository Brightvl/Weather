package com.example.weather;

import com.example.weather.SQL.ExampleJdbcConnection;

import java.sql.SQLException;

public class WeatherApp {


    public static void main(String[] args) {
        ExampleJdbcConnection ejc = new ExampleJdbcConnection();
        ejc.connectToDatabase();
//        ejc.insertUser();
        ejc.insertSomeUser();
//        ejc.updateData();
//        ejc.showAllUsers();
        ejc.closeConnection();
    }
}
