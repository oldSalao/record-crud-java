package kr.co.sist.recordcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordCrudDAO {
	private static RecordCrudDAO rcDAO;
	private List<String> studRecord;

	private RecordCrudDAO() {
		studRecord = new ArrayList<String>();
	}

	public List<String> getRecord() throws SQLException {
		studRecord.clear();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder selectRecord = new StringBuilder();
		StringBuilder result = null;

		DbConnection dc = DbConnection.getInstance();

		try {
			con = dc.getConnection();
			selectRecord.append("select * from stud");
			pstmt = con.prepareStatement(selectRecord.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = new StringBuilder();
				result.append(rs.getInt("num"));
				result.append(", ").append(rs.getString("name"));
				result.append(", ").append(rs.getInt("age"));
				result.append(", ").append(rs.getString("address"));
				studRecord.add(result.toString());
			}
		} finally {
			dc.close(con, pstmt, rs);
		}
		return studRecord;
	}

	public void insertRecord(String name, int age, String address) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuilder insertRecord = new StringBuilder();

		DbConnection dc = DbConnection.getInstance();

		try {
			con = dc.getConnection();
			insertRecord.append("insert into stud values (seq_stud.nextval,?,?,?)");
			pstmt = con.prepareStatement(insertRecord.toString());
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, address);
			pstmt.execute();
		} finally {
			dc.close(con, pstmt, null);
		}
	}

	public static RecordCrudDAO getInstance() {
		if (rcDAO == null) {
			rcDAO = new RecordCrudDAO();
		}
		return rcDAO;
	}
}
