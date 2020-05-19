package controller;

import java.util.Scanner;

import dto.Dept;
import service.face.DeptService;
import service.impl.DeptServiceImpl;

public class DeptEx {
	
	private static DeptService deptService = new DeptServiceImpl();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("조회할 부서는 ? : ");
		int deptno = sc.nextInt();
		
		Dept info = deptService.deptInfo(deptno);
		System.out.println(info);

	}

}
