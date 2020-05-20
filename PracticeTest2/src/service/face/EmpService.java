package service.face;

import java.util.List;

import dto.Emp;

public interface EmpService {
	
	public List<Emp> selectAll();
	public void selectIdx(int idx);
	public void deleteIdx(int idx);
	public void insertEmp(Emp emp);

}
