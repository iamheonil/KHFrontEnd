package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.face.DeptDao;
import dto.Dept;

public class DeptDaoImpl implements DeptDao {

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

	Scanner sc = new Scanner(System.in);

	// 생성자
	public DeptDaoImpl() { // 클래스명이랑 바꿩
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
	public List<Dept> selectAll() {

		String sql = "";
		sql += "SELECT * FROM dept ORDER BY deptno";

		List<Dept> deptList = new ArrayList<Dept>();

		try {
			// 쿼리 수행 객체 생성
			ps = conn.prepareStatement(sql);

			// 쿼리 수행
			rs = ps.executeQuery();

			while (rs.next()) {
				Dept d = new Dept();

				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLoc(rs.getString("loc"));

				deptList.add(d);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반납.
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

		return deptList;
	}

	@Override
	public void addDept(Dept dept) {

		String sql = "";

		sql += "INSERT INTO dept(DEPTNO, DNAME, LOC) VALUES (?, ?, ?)";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, dept.getDeptno());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLoc());

			ps.executeUpdate(); // 여기서 오류나면 아래의 캐치로 바로 넘어가서 캐치에서 롤백

			// 커밋 - 정상 동작
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// 롤백 - 잘못된 동작(SQL 수행 중 예외 발생)
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
