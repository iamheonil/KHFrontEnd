package service.impl;

import java.sql.Connection;

import dao.face.DeptDao;
import dao.impl.DeptDaoImpl;
import dbutil.DBConn;
import dto.Dept;
import service.face.DeptService;

public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao = new DeptDaoImpl();

	@Override
	public Dept deptInfo(int deptno) {

		Connection conn = DBConn.getConnection();
		
		Dept dept = deptDao.selectOne(conn, deptno);

		return dept;

	}

}
