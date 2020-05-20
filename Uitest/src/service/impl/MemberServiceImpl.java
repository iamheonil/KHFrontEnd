package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.face.MemberDao;
import dao.impl.MemberDaoImpl;
import dbutil.DBConn;
import dto.Member;
import service.face.MemberService;

public class MemberServiceImpl implements MemberService {

	private MemberDao mDao = new MemberDaoImpl();

	@Override
	public Member loginCheck(String userId, String userPwd) {
		Connection conn = DBConn.getConnection();

		Member loginMember = mDao.loginCheck(conn, userId, userPwd);

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loginMember;
	}

	@Override
	public ArrayList<Member> selectAll() {
		Connection conn = DBConn.getConnection();

		ArrayList<Member> list = mDao.selectAll(conn);

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Member selectOne(String userId) {
		Connection conn = DBConn.getConnection();

		Member member = mDao.selectOne(conn, userId);

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return member;
	}

	@Override
	public int insertMember(Member member) {
		Connection conn = DBConn.getConnection();

		int result = mDao.insertMember(conn, member);

		if (result > 0) {

			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}

	@Override
	public int updateMember(Member member) {
		Connection conn = DBConn.getConnection();

		int result = mDao.updateMember(conn, member);

		if (result > 0) {

			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}

	@Override
	public int deleteMember(String userId) {
		Connection conn = DBConn.getConnection();

		int result = mDao.deleteMember(conn, userId);

		if (result > 0) {

			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;

	}
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
}
