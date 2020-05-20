package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.face.MemberDao;
import dto.Member;

public class MemberDaoImpl implements MemberDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public Member loginCheck(Connection conn, String userId, String userPwd) {
//		System.out.println("호출!");

		String sql = "";

		sql += "SELECT userId, userPwd FROM MEMBER WHERE userId = ? AND userPwd = ?";

		Member member = null;

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, userId);
			ps.setString(2, userPwd);

			rs = ps.executeQuery();

			while (rs.next()) {
				Member m = new Member();

				m.setUserId(rs.getString("userId"));
				m.setUserPwd(rs.getString("userPwd"));
				m.setUserName(rs.getString("userName"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setHobby(rs.getString("hobby"));
				m.setEtc(rs.getString("etc"));
				m.setEnrollDate(rs.getDate("enrollDate"));
				m.setLastModified(rs.getDate("lastModified"));

				member = m;
				System.out.println(member);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return member;

	}

	@Override
	public ArrayList<Member> selectAll(Connection conn) {
		String sql = "";

		sql += "SELECT * FROM MEMBER";

		ArrayList<Member> member = new ArrayList<Member>();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				Member m = new Member();

				m.setUserId(rs.getString("userId"));
				m.setUserPwd(rs.getString("userPwd"));
				m.setUserName(rs.getString("userName"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setHobby(rs.getString("hobby"));
				m.setEtc(rs.getString("etc"));
				m.setEnrollDate(rs.getDate("enrollDate"));
				m.setLastModified(rs.getDate("lastModified"));

				member.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return member;

	}

	@Override
	public Member selectOne(Connection conn, String userId) {
		String sql = "";

		 sql += "SELECT * FROM MEMBER WHERE userId = " + userId;
//		sql += "SELECT * FROM EMP WHERE ENAME = " + userId;

		Member member = new Member();

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				Member m = new Member();

				m.setUserId(rs.getString("userId"));
				m.setUserPwd(rs.getString("userPwd"));
				m.setUserName(rs.getString("userName"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setHobby(rs.getString("hobby"));
				m.setEtc(rs.getString("etc"));
				m.setEnrollDate(rs.getDate("enrollDate"));
				m.setLastModified(rs.getDate("lastModified"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return member;

	}

	@Override
	public int insertMember(Connection conn, Member member) {
		String sql = "";

		sql += "INSERT INTO MEMBER(USERID, USERPWD, USERNAME, GENDER, AGE, PHONE, EMAIL, HOBBY, ETC, ENROLLDATE, LASTMODIFIED) VALUES (HEONIL, HEONIL, KIM, MALE, 26, 010-4175-7452, KIMHEONIL@NAVER.COM, COMPUTER, -, 20/05/2020, 20/05/2020)";

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				Member m = new Member();

				m.setUserId(rs.getString("userId"));
				m.setUserPwd(rs.getString("userPwd"));
				m.setUserName(rs.getString("userName"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setHobby(rs.getString("hobby"));
				m.setEtc(rs.getString("etc"));
				m.setEnrollDate(rs.getDate("enrollDate"));
				m.setLastModified(rs.getDate("lastModified"));

//				conn.commit(); // 저장 성공시
//				System.out.println("Commit");
				// Service 에서 해주는 중.

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int updateMember(Connection conn, Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(Connection conn, String userId) {
		String sql = "";

		sql += "DELETE FROM MEMBER WHERE userId = " + userId;
		//sql += "DELETE FROM EMP WHERE ENAME = " + userId; // 문법체크용

		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

//			while (rs.next()) {
//				Member m = new Member();
//
//				m.setUserId(rs.getString("userId"));
//				m.setUserPwd(rs.getString("userPwd"));
//				m.setUserName(rs.getString("userName"));
//				m.setGender(rs.getString("gender"));
//				m.setAge(rs.getInt("age"));
//				m.setPhone(rs.getString("phone"));
//				m.setEmail(rs.getString("email"));
//				m.setHobby(rs.getString("hobby"));
//				m.setEtc(rs.getString("etc"));
//				m.setEnrollDate(rs.getDate("enrollDate"));
//				m.setLastModified(rs.getDate("lastModified"));
//
//			}
		
			System.out.println("Delete Success");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;

	}

}
