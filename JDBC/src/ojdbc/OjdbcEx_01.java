package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OjdbcEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println("Hello Java");

		// 1. JDBC Load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// -------------- OJDBC 사용에 필요한 변수들 미리 로드하기
			
			// DB Connection Object
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
		
		// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		// 2. DB Connection
			try {
				conn = DriverManager.getConnection
						("jdbc:oracle:thin:@192.168.120.13:1521:xe", "system", "oracle");
				
		// 3. Query 수행 Object
				st = conn.createStatement();
				
				
		// 3.2 SQL Query 수행 및 결과 저장 (ResultSet)
				rs = st.executeQuery("SELECT * FROM EMP ORDER BY EMPNO");
				
				// 조회된 행이 존재하는 만큼 반복하는 코드
				
		// 4. 조회된 결과 처리 
				while(rs.next()) {
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
				// 5. Exit
					if(rs != null) rs.close();
					if(st != null) st.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


	}

}
