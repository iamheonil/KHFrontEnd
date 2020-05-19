package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Doctor;

public interface DoctorDao {

	public List<Doctor> allDoctor(Connection conn);
	public List<Doctor> selectidx(Connection conn, int idx);
	
	public void insertDoctor(Connection conn, Doctor doctor);
	
	public void deleteidx(Connection conn, int i);
	
}
