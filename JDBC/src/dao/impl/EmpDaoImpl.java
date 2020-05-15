package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.EmpDao;
import dto.Emp;

public class EmpDaoImpl implements EmpDao {
	// Implements

	@Override
	public List<Emp> selectAll() {
		// SQL 식 작성
		String sql = "";
		sql += "SELECT * FROM EMP ORDER BY EMPNO";

		// 결과 저장 될 List
		List<Emp> list = new ArrayList<Emp>();

		try {
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql);

			// SQL 수행 및 결과 저장
			rs = ps.executeQuery();

			// 결과 처리
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
	public List<Emp> selectDeptno20() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> selectByDeptno(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Emp emp) {
		// TODO Auto-generated method stub

	}

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

	public EmpDaoImpl() {
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
}
