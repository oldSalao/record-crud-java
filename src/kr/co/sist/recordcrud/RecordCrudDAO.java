package kr.co.sist.recordcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordCrudDAO {
	private static RecordCrudDAO rcDAO;
	private List<StudentVO> studList;

	private RecordCrudDAO() {
		studList = new ArrayList<StudentVO>();
	}

	public List<StudentVO> selectAllStud() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder selectRecord = new StringBuilder();
		StudentVO studVO = null;

		DbConnection dc = DbConnection.getInstance();

		try {
			con = dc.getConnection();
			selectRecord.append("select * from stud order by num");
			pstmt = con.prepareStatement(selectRecord.toString());
			rs = pstmt.executeQuery();

			if (!studList.isEmpty()) {
				studList.clear();
			}

			while (rs.next()) {
				studVO = new StudentVO(rs.getInt("num"), rs.getString("name"), rs.getInt("age"),
						rs.getString("address"));
				studList.add(studVO);
			}
		} finally {
			dc.close(con, pstmt, rs);
		}
		return studList;
	}

	public List<StudentVO> getStudList() {
		return studList;
	}

	public void insertRecord(String name, int age, String address) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuilder insertRecord = new StringBuilder();
		StudentAddVO studAddVO = new StudentAddVO(name, age, address);
		DbConnection dc = DbConnection.getInstance();

		try {
			con = dc.getConnection();
			insertRecord.append("insert into stud values (seq_stud.nextval,?,?,?)");
			pstmt = con.prepareStatement(insertRecord.toString());
			pstmt.setString(1, studAddVO.getName());
			pstmt.setInt(2, studAddVO.getAge());
			pstmt.setString(3, studAddVO.getAddress());
			pstmt.execute();
		} finally {
			dc.close(con, pstmt, null);
		}
	}

	public void deleteRecord(int num) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuilder insertRecord = new StringBuilder();
		DbConnection dc = DbConnection.getInstance();

		try {
			con = dc.getConnection();
			insertRecord.append("delete from stud where num = ?");
			pstmt = con.prepareStatement(insertRecord.toString());
			pstmt.setInt(1, num);
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
