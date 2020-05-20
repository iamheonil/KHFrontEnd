package controller;

import java.util.List;

import dto.Emp;
import service.face.EmpService;
import service.impl.EmpServiceImpl;

public class EmpEx {

	private static EmpService empService = new EmpServiceImpl();
	
	public static void main(String[] args) {
		
		List<Emp> list = empService.selectAll();
		
//		System.out.println(list);
		
		empService.selectIdx(2222);
		
//		empService.deleteIdx(1111);

	}

}
