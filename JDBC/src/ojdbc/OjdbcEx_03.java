package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OjdbcEx_03 {

	// OJDBC Driver Load
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	// Login Info
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	// OJDBC Object
	private static Connection conn = null; // DB Connection Object
	private static Statement st = null; // SQL Statement
	private static PreparedStatement ps = null;

	private static ResultSet rs = null; // SQL Result

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Driver Load

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String job = "MANAGER";

		// SQL 작성
//		String sql = "";
//		
//		sql += "SELECT * FROM EMP";
////		sql += " WHERE job = 'SALESMAN'";
//		sql += " WHERE job = '" + job + "'";
//		sql += " ORDER BY EMPNO";

		String sql = "";

		sql += "SELECT * FROM EMP";
//		sql += " WHERE job = 'SALESMAN'"; // job 으로 대체
		sql += " WHERE job = ?";
		sql += " ORDER BY EMPNO";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

//			st = conn.createStatement();
//			rs = st.executeQuery(sql);

			// SQL 수행객체
			// Statement 객체는 생성 CreateStatement()) 될 때 매개변수가 없다.
			// execute할 때 쿼리를 매개변수로 전달한다.

			// execute 수행할 때 매개변수 없음

			// execute 전에 ? 에 대한 값을 채워줘야한다.

			ps = conn.prepareStatement(sql);
			ps.setString(1, job);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getString("EMPNO") + ", ");
				System.out.print(rs.getString("ENAME") + ", ");
				System.out.print(rs.getString("JOB") + ", ");
				System.out.print(rs.getString("MGR") + ", ");
				System.out.print(rs.getString("HIREDATE") + ", ");
				System.out.print(rs.getString("SAL") + ", ");
				System.out.print(rs.getString("COMM") + ", ");
				System.out.println(rs.getString("DEPTNO") + ", ");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (ps != null) {
					ps.close();
				}

				if (conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
