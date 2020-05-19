package service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.face.DoctorDao;
import dao.impl.DoctorDaoImpl;
import dbutil.DBConn;
import dto.Doctor;
import service.face.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	private DoctorDao doctorDao = new DoctorDaoImpl();

	@Override
	public List<Doctor> allDoctor() {
		Connection conn = DBConn.getConnection();
		
//		List<Doctor> list = new ArrayList<Doctor>();
		List<Doctor> doctor = doctorDao.allDoctor(conn);
		
		return doctor;
	}



	@Override
	public List<Doctor> selectDoc(int i) {
		Connection conn = DBConn.getConnection();
		
		List<Doctor> doctor = doctorDao.selectidx(conn, i);

		return doctor;
	}
//
	@Override
	public void insertDoc(Doctor doctor) {
		Connection conn = DBConn.getConnection();
		
		doctorDao.insertDoctor(conn, doctor);
		

	}
//
	@Override
	public void deleteDoc(int i) {
		Connection conn = DBConn.getConnection();
		
		doctorDao.deleteidx(conn, i);

	}

}
