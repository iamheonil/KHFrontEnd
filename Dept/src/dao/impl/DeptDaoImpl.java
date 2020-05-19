package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.DeptDao;
import dto.Dept;

public class DeptDaoImpl implements DeptDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public Dept selectOne(Connection conn, int deptno) {

		
		String sql = "";
		sql += "SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		Dept dept = null;
		
		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				Dept d = new Dept();

				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLoc(rs.getString("loc"));

				dept = d;
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

		return dept;

	}

}
