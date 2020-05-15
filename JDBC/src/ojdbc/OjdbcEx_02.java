package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.net.aso.r;

public class OjdbcEx_02 {

	// OJDBC Driver Load
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	// Login Info
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	// OJDBC Object
	private static Connection conn = null; // DB Connection Object
	private static Statement st = null; // SQL Statement
	private static ResultSet rs = null; // SQL Result

	public static void main(String[] args) {

		// Driver Load

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

		// SQL Query

		String sql1 = "";
		sql1 += "CREATE TABLE userTest (";
		sql1 += "	idx NUMBER CONSTRAINT pk_user_test PRIMARY KEY,";
		sql1 += "	name VARCHAR2(50) NOT NULL,";
		sql1 += "	phone VARCHAR2(50) NOT NULL)";

		String sql2 = "";
		sql2 += "CREATE SEQUENCE seq_usertest";
		sql2 += "	INCREMENT BY 1";
		sql2 += " 	START WITH 1";

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

		// Connection Object
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// SQL Start
			st = conn.createStatement(); // Statement Object Get

			st.execute(sql1);
			st.execute(sql2);

			// 생성 후 결과처리
			rs = st.executeQuery("SELECT COUNT(*) FROM TABS WHERE table_name = ('USERTEST')");

			rs.next();

			// rs.getInt("count(*)");
			rs.getInt(1);

			if (rs.getInt(1) > 0) {
				System.out.println("테이블이 생성 완료되었습니다.");
			} else {
				System.out.println("테이블 생성에 실패하였습니다.");
			}

			ResultSet rs2 = null;
			rs2 = st.executeQuery("SELECT COUNT(*) FROM user_sequences WHERE SEQUENCE_NAME = UPPER('seq_usertest')");

			rs2.next();

			if (rs2.getInt(1) > 0) {
				System.out.println("시퀀스가 생성 완료되었습니다.");
			} else {
				System.out.println("테이블 생성에 실패하였습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (st != null) {
					st.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

	}
}