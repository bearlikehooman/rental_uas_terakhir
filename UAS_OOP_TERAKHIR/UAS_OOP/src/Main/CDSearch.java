package Main;

import java.util.*;
import java.sql.*;
public class CDSearch {
	private Connection conn;
	
	public CDSearch() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uas_database", "root", "");
	}
	
	public List<CD> getAllCDs() throws Exception {
		List<CD> list = new ArrayList<>();
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery("SELECT * FROM cd");
			
			while(rs.next()){
				CD tempCD = convertRowToCD(rs);
				list.add(tempCD);
			}
			return list;
		}finally {
			close(statement, rs);
		}
	}
	
	public List<CD> searchCDs(String cdTitle) throws Exception {
		List<CD> list = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		try {
			cdTitle += "%";
			statement = conn.prepareStatement("select * from cd where title like ?");
			
			statement.setString(1, cdTitle);
			
			rs = statement.executeQuery();
			
			while (rs.next()) {
				CD tempCD = convertRowToCD(rs);
				list.add(tempCD);
			}
			
			return list;
		}finally {
			close(statement, rs);
		}
	}
	
	private CD convertRowToCD(ResultSet rs) throws SQLException {
		int idCD = rs.getInt("idCD");
		String title = rs.getString("title");
		String qty = rs.getString("qty");
		String price = rs.getString("price");
		String status = rs.getString("status");
		
		CD tempCD = new CD(idCD, title, qty, price, status);
		
		return tempCD;
	}
	
	private static void close(Connection conn, Statement statement, ResultSet rs)
			throws SQLException {

		if (rs != null) {
			rs.close();
		}

		if (statement != null) {
			
		}
		
		if (conn != null) {
			conn.close();
		}
	}
	
	private void close(Statement statement, ResultSet rs) throws SQLException {
		close(null, statement, rs);		
	}
	
}
