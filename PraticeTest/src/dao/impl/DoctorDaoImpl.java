package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.DoctorDao;
import dto.Doctor;

public class DoctorDaoImpl implements DoctorDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Doctor> allDoctor(Connection conn) {
		String sql = "";
		sql += "SELECT * FROM DOCTOR";
		List<Doctor> list = new ArrayList<Doctor>();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				Doctor d = new Doctor();

				d.setDoccode(rs.getInt("DOC_CODE"));
				d.setDocname(rs.getString("DOC_NAME"));
				d.setDepcode(rs.getInt("DEP_CODE"));

				list.add(d);
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
	public List<Doctor> selectidx(Connection conn, int idx) {
		String sql = "";

		sql += "SELECT * FROM DOCTOR WHERE DOC_CODE = " + idx;

		List<Doctor> list = new ArrayList<Doctor>();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				Doctor doctor = new Doctor();

				doctor.setDoccode(rs.getInt("DOC_CODE"));
				doctor.setDocname(rs.getString("DOC_NAME"));
				doctor.setDepcode(rs.getInt("DEP_CODE"));

				list.add(doctor);
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public void insertDoctor(Connection conn, Doctor doctor) {
		String sql = "";

		sql += "INSERT INTO USERTEST(IDX, USERID, NAME) VALUES (?, ?, ?)";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, doctor.getDoccode());
			ps.setString(2, doctor.getDocname());
			ps.setInt(3, doctor.getDepcode());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
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
	public void deleteidx(Connection conn, int i) {
		String sql = "";

		sql += "DELETE FROM USERTEST WHERE IDX =" + i;

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

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
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
