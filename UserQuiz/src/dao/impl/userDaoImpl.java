package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.userDao;
import dto.User;

public class userDaoImpl implements userDao {

	// OJDBC Driver Load
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	// Login Info
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	// OJDBC Object
	private static Connection conn = null; // DB Connection Object
//	private static Statement st = null; // SQL Statement
	private static PreparedStatement ps = null; // SQL PreparedStatement
	private static ResultSet rs = null; // SQL Result

	public userDaoImpl() {
		try {
			Class.forName(DRIVER);

			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub

		String sql = "";

		sql += "SELECT * FROM userTest";

		List<User> list = new ArrayList<User>();

		try {
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// 결과 처리
			while (rs.next()) {

				// 새로운 빈 User 객체 생성
				User user = new User();

				// ResultSet에서 User 객체에 데이터 담기
				user.setIdx(rs.getInt("idx"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));

				// DTO를 list에 담기
				list.add(user);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Close
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 조회 결과 반환
		return list;
	}

	@Override
	public List<User> selectByIdx() {
		String sql = "";
		sql += "SELECT * FROM userTest WHERE idx like 20";

		// 결과 저장 될 List
		List<User> list = new ArrayList<User>();

		try {
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// 결과 처리
			while (rs.next()) {

				// 새로운 빈 User 객체 생성
				User user1 = new User();

				// ResultSet에서 User 객체에 데이터 담기
				user1.setIdx(rs.getInt("idx"));
				user1.setUserid(rs.getString("userid"));
				user1.setName(rs.getString("name"));

				// DTO를 list에 담기
				list.add(user1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Close
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 조회 결과 반환
		return list;

	}

	@Override
	public void insertUser(User user) {
		String sql = "";
		// userId : A123
		// name : Alice

		sql += "INSERT INTO userTest(idx, userid, name) VALUES (" + "userTest_SQ.nextval" + ", A123, Alice)";

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public List<User> deleteByIdx() {
		String sql = "";
		sql += "DELETE * FROM EMP ORDER BY EMPNO";

		// 결과 저장 될 List
		List<User> list = new ArrayList<User>();

		try {
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// 결과 처리
			while (rs.next()) {

				// 새로운 빈 User 객체 생성
				User user = new User();

				// ResultSet에서 User 객체에 데이터 담기
				user.setIdx(rs.getInt("idx"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));

				// DTO를 list에 담기
				list.add(user);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Close
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 조회 결과 반환
		return list;

	}

}
