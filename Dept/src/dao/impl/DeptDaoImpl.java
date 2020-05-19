package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.face.DeptDao;
import dto.Dept;

public class DeptDaoImpl implements DeptDao {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	

	@Override
	public Dept selectOne(Connection conn, int deptno) {

		
		
		return null;
	}

}
