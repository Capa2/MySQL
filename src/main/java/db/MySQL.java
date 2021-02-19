package db;

import java.sql.*;

public class MySQL {
    Accessor accessor;
    Connection con;
    PreparedStatement stmt;

    public MySQL() {
        accessor = new Accessor();
        openCon();
        isConClosed();
        closeCon();
        isConClosed();
        openCon();
        isConClosed();
    }
    // Manage Connection with Open() Close()
    private void openCon() {con = getConnectionAs("root", "mq224jok", "db");}

    private void closeCon() {accessor.disconnect();}

    private Connection getConnectionAs(String username, String password, String database) {
        accessor.connect(username, password, database); // Enter credentials & select database
        return accessor.getConnection(); // Get connection object
    }
    private void isConClosed() {
        try {
            System.out.println(con.isClosed());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
