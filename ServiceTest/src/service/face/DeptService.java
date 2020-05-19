package service.face;

import java.util.List;

import dto.Dept;

public interface DeptService {
	
	/** 부서 정보 전체 조회
	 * @return List<Dept> - 조회된 부서 정보 리스트
	 * 
	 */
	public List<Dept> deptList();
	
	/**
	 * 부서 정보 추가 
	 * @param dept
	 */
	public void addDept(Dept dept);

}
