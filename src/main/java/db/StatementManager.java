package db;

import java.sql.*;

public class StatementManager {
    Connection con;
    PreparedStatement stmt;
    ResultSet result;
    boolean executed;
    int rowsAffected;
    String sql;

    public StatementManager() {
    }

    public void execute() {
        if (sql.equals(null)) return;
        if (sql.toUpperCase().startsWith("UPDATE") ||
                sql.toUpperCase().startsWith("DELETE") ||
                sql.toUpperCase().startsWith("INSERT")) executeUpdate();
        else if (sql.toUpperCase().startsWith("SELECT")) executeQuery();
        else executeCmd();
    }

    private void executeQuery() {
        try {
            result = stmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void executeUpdate() {
        try {
            rowsAffected = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void executeCmd() {
        try {
            executed = stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (executed) {
            try {
                result = stmt.getResultSet();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public ResultSet getResult() {
        return result;
    }

    public void closeResult() {
        try {
            result.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void state(String sql) {
        try {
            stmt = con.prepareStatement(sql);
            this.sql = sql;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setConnection(Connection con) {
        this.con = con;
    }

    public void setString(int index, String string) {
        try {
            stmt.setString(index, string);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setInt(int index, int value) {
        try {
            stmt.setInt(index, value);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setLong(int index, long value) {
        try {
            stmt.setLong(index, value);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
