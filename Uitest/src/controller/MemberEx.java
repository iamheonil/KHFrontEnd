package controller;

import java.sql.Connection;

import dbutil.DBConn;
import service.face.MemberService;
import service.impl.MemberServiceImpl;

public class MemberEx {

	private static Connection conn = DBConn.getConnection();
	private static MemberService memberService = new MemberServiceImpl();
	
	public static void main(String[] args) {
		
//		memberService.loginCheck("STAR", "LOAD");
//		memberService.loginCheck("SMITH", "CLERK");
		
//		System.out.println(memberService.selectAll());
		
//		System.out.println(memberService.selectOne("SMITH"));
		
//		memberService.insertMember(null);
		
//		memberService.selectOne("SMITH");
		
		memberService.deleteMember(null);
		
		
	}

}
