package controller;

import java.util.List;

import dto.Doctor;
import service.face.DoctorService;
import service.impl.DoctorServiceImpl;

public class DoctorEx {

	private static DoctorService doctorService = new DoctorServiceImpl();

	public static void main(String[] args) {

		List<Doctor> doc = doctorService.allDoctor();

		System.out.println(doc);

		List<Doctor> seDoc = doctorService.selectDoc(0000);
		
//		System.out.println(seDoc);
		
		Doctor doctor = new Doctor();
		
		doctor.setDoccode(1030);
		doctor.setDocname("헌선생");
		doctor.setDepcode(0203);
		
//		doctorService.insertDoc(doctor);
		
		doctorService.deleteDoc(1030);
		
		
		
		
	}

}
