package db;

public class Driver {
    String driver;

    public Driver(String driver) {
        this.driver = driver;
        loadDriver(this.driver);
    }

    public Driver() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        loadDriver(this.driver);
    }


    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
