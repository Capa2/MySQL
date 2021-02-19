package db;

import java.sql.*;

abstract class MySQL {
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement stmt;

    private void openCon() {
        connection = getConnectionAs("root", "mq224jok", "db");
    }

    private void closeCon() {
        connectionManager.disconnect();
    }

    private Connection getConnectionAs(String username, String password, String database) {
        connectionManager.connect(username, password, database); // Enter credentials & select database
        return connectionManager.getConnection(); // Get connection object
    }

    private void isConClosed() {
        try {
            System.out.println(connection.isClosed());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
