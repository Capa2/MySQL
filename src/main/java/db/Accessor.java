package db;

import java.sql.*;

public class Accessor {
    Connection connection;
    String url, username, password, database;

    public Accessor() {
        loadDriver();
        url = "jdbc:mysql://localhost:3306/"; // Server URL
    }

    public Accessor(String url) {
        loadDriver();
        this.url = url; // Server URL
    }

    public void connect(String username, String password, String database) { // Connect to database
        setCredentials(username, password, database);
        if (connection != null) disconnect();
        try {
            connection = DriverManager.getConnection(url + database, username, password);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void connect() {
        connect(username, password, database);
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    public void setCredentials(String username, String password, String database) {
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public Connection getConnection() {
        if (connection == null) System.out.println("Connection is null");
        return connection;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
