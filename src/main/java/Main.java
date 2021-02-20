import db.*;

public class Main {
    public static void main(String[] args) {
        MySQL bankdb = new Bankdb();
        bankdb.openCon();
        bankdb.isConClosed();
        bankdb.closeCon();
        bankdb.isConClosed();
    }
}
