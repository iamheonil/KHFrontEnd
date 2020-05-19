package service.face;

import java.util.List;

import dto.Doctor;

public interface DoctorService {

	public List<Doctor> allDoctor();
	public List<Doctor> selectDoc(int i);
	public void insertDoc(Doctor doctor);
	public void deleteDoc(int i);
	
}
