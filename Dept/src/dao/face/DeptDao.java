package dao.face;

import java.sql.Connection;

import dto.Dept;

public interface DeptDao {
	
	public Dept selectOne(Connection conn, int deptno);

}
