package service.impl;

import java.util.List;

import dao.face.DeptDao;
import dao.impl.DeptDaoImpl;
import dto.Dept;
import service.face.DeptService;

public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	public List<Dept> deptList() {

		List<Dept> list = deptDao.selectAll();
		
		return list;
	}

	@Override
	public void addDept(Dept dept) {
		
		deptDao.addDept(dept);
		
	}
}
