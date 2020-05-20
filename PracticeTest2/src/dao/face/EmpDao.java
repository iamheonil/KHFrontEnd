package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Emp;

public interface EmpDao {
	
	public List<Emp> selectAll(Connection conn);
	
	public void selectIdx(Connection conn, int idx);
	
	public void deleteIdx(Connection conn, int idx);
	
	public void insertEmp(Connection conn, Emp emp);

}
