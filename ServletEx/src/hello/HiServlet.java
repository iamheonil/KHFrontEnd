package hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 매개변수
		// HttpServletRequest : HTTP 요청 정보 객체
		// HttpServletResponse : HTTP 응답 정보 객체
		
		// 응답 메시지의 형식을 알려주는 코드
		// text/html -> html 형식의 text 이고,
		// charset = utf-8 -> 캐릭터 인코딩은 utf-8이다
		
		resp.setContentType("text/html;charset=utf-8");
		
		
		System.out.println("get Method Response");
		
		resp.getWriter().println("<h1>오우 너무 재밌꼬</h1>");
		
		System.out.println("Console Check, Test Stream Print");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
	}

}
