package service.face;

import java.util.ArrayList;

import dto.Member;

public interface MemberService {
	
	public Member loginCheck(String userId, String userPwd);
	public ArrayList<Member> selectAll();
	public Member selectOne(String userId);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String userId);

}
