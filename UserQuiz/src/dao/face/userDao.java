package dao.face;

import java.util.List;

import dto.User;

public interface userDao {

	public List<User> selectAll();

	public List<User> selectByIdx(int i);

//	public List selectByIdx(int i);
	public void insertUser(User user);

	public List<User> deleteByIdx(int i);

}
