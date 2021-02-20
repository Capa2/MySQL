package db;
import java.sql.*;

public abstract class MySQL {
    private ConnectionManager connectionManager;
    private Connection con;
    public void openCon() {
        con = getConnectionAs("root", "mq224jok", "db");
    }

    public void closeCon() {
        connectionManager.disconnect();
    }

    private Connection getConnectionAs(String username, String password, String database) {
        if (connectionManager == null) connectionManager = new ConnectionManager();
        connectionManager.connect(username, password, database); // Enter credentials & select database
        return connectionManager.getConnection(); // Get connection object
    }

    public void isConClosed() {
        try {
            System.out.println(con.isClosed());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
