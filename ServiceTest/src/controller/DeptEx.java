package controller;

import java.util.List;

import dto.Dept;
import service.face.DeptService;
import service.impl.DeptServiceImpl;

public class DeptEx {
	
	// Service Object
	private static DeptService deptService = new DeptServiceImpl();
	
	public static void main(String[] args) {

		// Dept(부서) 테이블의 모든 데이터 조회
		
		List<Dept> list = deptService.deptList();
		
		// Result Check
		for (Dept d : list) {
			System.out.println(d);
		}
		
		// -=-=-=-=-=-=-=-==--==--==--=-=-=-==-=--=-=-=-=-=-=-=
		
		Dept dept = new Dept();
		
		dept.setDeptno(50);
		dept.setDname("STATION");
		dept.setLoc("TOKYO");
		
		deptService.addDept(dept);
			
	}

}
