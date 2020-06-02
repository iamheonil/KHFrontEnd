package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Singleton 적용 - DB 연결
//	Connection 객체를 하나만 만들어서 사용할 수 있게 한다.

public class JDBCTemplate {

	// OJDBC Driver Load
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	// Login Info
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	// OJDBC Object
	private static Connection conn = null; // DB Connection Object

	// 생성자
	private JDBCTemplate() {
	}// 외부에서 객체 생성하는 걸 막는 용도

	// Connection 객체 반환 - 싱글톤 패턴 적용 메소드
	public static Connection getConnection() {

		// 한번 생성된 객체를 유지하게 만드는 조건문
		if (conn == null) {
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

		return conn;
		// DB 연결 객체 반환
	}

	public static void commit(Connection conn) {

		try {

			if (conn != null && !conn.isClosed() ) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	// rollback 수행 메소드
	public static void rollback(Connection conn) {

		try {
			if (conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// DB Connection Close
	public static void close(Connection conn) {

		try {
			if (conn != null & !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// SQL Syntax Close
	public static void close(PreparedStatement ps) {

		try {
			if (ps != null & !ps.isClosed()) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//public static void close(Statement st) {
	//	
	// }

	// SQL Result Close
	public static void close(ResultSet rs) {

		try {
			if (rs != null & !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



}


















