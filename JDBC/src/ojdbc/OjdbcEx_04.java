package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Emp;

public class OjdbcEx_04 {

	// OJDBC Driver Load
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	// Login Info
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	// OJDBC Object
	private static Connection conn = null; // DB Connection Object
//	private static Statement st = null; // SQL Statement
	private static PreparedStatement ps = null; // SQL PreparedStatement Object
	private static ResultSet rs = null; // SQL Result Object

	public static void main(String[] args) {

		// Driver Load

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

		
		// 전체 조회 결과를 저장할 리스트
		List<Emp> list = new ArrayList<>();
		
		// Driver Load

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String job = "MANAGER";

		String sql = "";

		sql += "SELECT * FROM EMP";
		sql += " WHERE job = ?";
		sql += " ORDER BY EMPNO";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			ps = conn.prepareStatement(sql);
			ps.setString(1, job);
			rs = ps.executeQuery();

			while (rs.next()) {
				
				// 새로운 빈 Emp 객체 생성
				Emp emp = new Emp();
				
				// ResultSet에서 Emp 객체에 데이터 담기
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				// DTO를 list에 담기
				list.add(emp);
				
			}
						
			for (int i = 0; i < list.size(); i++) {
				
				System.out.println(list.get(i));
				
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
