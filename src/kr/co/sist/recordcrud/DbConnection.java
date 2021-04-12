package kr.co.sist.recordcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
	private static DbConnection dc;

	private DbConnection() {
	}

	public static DbConnection getInstance() {
		if (dc == null) {
			dc = new DbConnection();
		}
		return dc;
	}

	public Connection getConnection() throws SQLException {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		con = DriverManager.getConnection(url, id, pass);

		return con;
	}

	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if (con != null) {
			con.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
}