package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Konfig {
    private static Connection MySqLConfig;
    public static Connection configDB() throws SQLException{
        try {

            String url = "jdbc:mysql://localhost:3306/uas_database";
            String user ="root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySqLConfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e){
            System.out.printf("Koneksi DB gagal : " + e.getMessage());
        }
        return MySqLConfig;
    }
}
