package dao.face;

import java.sql.Connection;
import java.util.ArrayList;

import dto.Member;

public interface MemberDao {

	public Member loginCheck(Connection conn, String userId, String userPwd);

	public ArrayList<Member> selectAll(Connection conn);

	public Member selectOne(Connection conn, String userId);

	public int insertMember(Connection conn, Member member);

	public int updateMember(Connection conn, Member member);

	public int deleteMember(Connection conn, String userId);
}
