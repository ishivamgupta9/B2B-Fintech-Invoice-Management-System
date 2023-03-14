package highradius_project.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SlNo {
	public static int sl_no() throws SQLException {
		int sl_no=0;
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/grey_goose";
		String uname = "root";
		String pass = "root";
		con = DriverManager.getConnection(url, uname, pass);
		String sql = "SELECT * FROM winter_internship ORDER BY sl_no DESC LIMIT 1";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sl_no = rs.getInt("sl_no");
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sl_no+1;
		
		
	}
}
