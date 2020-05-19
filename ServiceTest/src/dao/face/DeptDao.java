package dao.face;

import java.util.List;

import dto.Dept;

public interface DeptDao {
	/*
	 * DEPT 테이블 전체 조회
	 * 
	 * @return List<Dept> - 조회된 전체 행
	 */

	public List<Dept> selectAll();

	/**
	 * DEPT 테이블에 전달인자 dept를 삽입한다.
	 * 
	 * @param dept
	 */

	public void addDept(Dept dept);

}
