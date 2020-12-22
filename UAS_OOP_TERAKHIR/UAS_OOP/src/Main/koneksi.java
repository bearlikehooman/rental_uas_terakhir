package Main;
import java.sql.*;
public class koneksi {

    public Connection conn;
    public koneksi() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uas_database", "root", "");
    }
    public boolean isConnected(){
        return( conn != null);
    }

}
