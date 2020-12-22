package Main;
import java.sql.SQLException;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        new Login();
        try{
            koneksi db = new koneksi();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
