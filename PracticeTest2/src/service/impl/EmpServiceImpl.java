package service.impl;

import java.sql.Connection;
import java.util.List;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dbutil.DBConn;
import dto.Emp;
import service.face.EmpService;

public class EmpServiceImpl implements EmpService {

	private EmpDao empDao = new EmpDaoImpl();
	
	@Override
	public List<Emp> selectAll() {
		
		Connection conn = DBConn.getConnection();
		
		List<Emp> allList = empDao.selectAll(conn);
		
		return allList;
	}

	@Override
	public void selectIdx(int idx) {
		
		Connection conn = DBConn.getConnection();
		
		empDao.selectIdx(conn, idx);
		
	}

	@Override
	public void deleteIdx(int idx) {
		
		Connection conn = DBConn.getConnection();

		empDao.deleteIdx(conn, idx);
		
		
	}

	@Override
	public void insertEmp(Emp emp) {
		
		Connection conn = DBConn.getConnection();
		
		empDao.insertEmp(conn, emp);
		
	}
	
	

}
