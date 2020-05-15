package ex;

import java.util.List;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;

public class EmpEx {

	// Emp 객체 생성
	private static EmpDao empDao = new EmpDaoImpl();
	
	public static void main(String[] args) {
		
		// DAO를 통한 Emp테이블 전체 조회
	
		List<Emp> list = empDao.selectAll();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		

	}

}
