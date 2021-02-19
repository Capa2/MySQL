package db;

import java.sql.*;

public class Accessor {
    Connection connection;
    String url, database, dbUser, dbUserPass;

    public Accessor() {
        loadDriver();
        url = "jdbc:mysql://localhost:3306/"; // Server URL
    }
    public Accessor(String url) {
        loadDriver();
        this.url = url; // Server URL
    }
    public void connect() {
        connect(database, dbUser, dbUserPass);
    }

    public void connect(String database, String user, String pass) { // Connect to database
        try {
            connection = DriverManager.getConnection(url + database, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get Connection

    public Connection getConnection() {
        return connection;
    }

    // Edit connection parameters:

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public void setDbUserPass(String dbUserPass) {
        this.dbUserPass = dbUserPass;
    }
}
