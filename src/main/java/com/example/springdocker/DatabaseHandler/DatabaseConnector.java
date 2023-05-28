package com.example.springdocker.DatabaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/databasnamn";
    private static final String USERNAME = "användarnamn";
    private static final String PASSWORD = "lösenord";

    private Connection connection;

    public DatabaseConnector() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Databasanslutning etablerad!");
        } catch (SQLException e) {
            System.err.println("Kunde inte ansluta till databasen!");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Databasanslutning stängd.");
        } catch (SQLException e) {
            System.err.println("Kunde inte stänga databasanslutningen!");
            e.printStackTrace();
        }
    }
}
