package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.EmpDao;
import dto.Emp;

public class EmpDaoImpl implements EmpDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Emp> selectAll(Connection conn) {

		List<Emp> list = new ArrayList<Emp>();

		String sql = "";

		sql += "SELECT * FROM EMP";

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				Emp emp = new Emp();

				emp.setEmpno(rs.getInt("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setJob(rs.getString("JOB"));
				emp.setHiredate(rs.getDate("HIREDATE"));

				list.add(emp);

			}
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

		return list;
	}

	@Override
	public void selectIdx(Connection conn, int idx) {

		String sql = "";
		sql += "SELECT * FROM EMP WHERE EMPNO = " + idx;

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				Emp emp = new Emp();
				List<Emp> empList = new ArrayList<Emp>();

				emp.setEmpno(rs.getInt("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setJob(rs.getString("JOB"));
				emp.setHiredate(rs.getDate("HIREDATE"));

				empList.add(emp);

				System.out.println(empList);
			}
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
	public void deleteIdx(Connection conn, int idx) {

		String sql = "";

		sql += "DELETE FROM EMP WHERE EMPNO =" + idx;

		try {

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			conn.commit();
			System.out.println("Delete Success");

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
	public void insertEmp(Connection conn, Emp emp) {

		String sql = "";

		sql += "INSERT INTO EMP VALUE (?, ?, ?, ?)";

		try {

			ps = conn.prepareStatement(sql);

			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setDate(4, (Date) emp.getHiredate());

			rs = ps.executeQuery();

			conn.commit();
			System.out.println("Delete Success");

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

}
