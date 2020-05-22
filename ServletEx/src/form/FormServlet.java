package form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/form.do")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Form Servlet : /form.do - GET Request");

		// JSP 로 응답데이터를 만들기
		RequestDispatcher rd;

		rd = req.getRequestDispatcher("/WEB-INF/views/inputForm.jsp");

		// JSP 를 이용한 응답 보내기
		rd.forward(req, resp); // 포워드, 포워딩 한다고 표현한다.

	}

	@Override
	// inputForm.jsp 기준
	// req - URL, Method(Post), Parameter(Query String)
	// resp -
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// '요청' 데이터의 한글 인코딩 UTF-8 설정
		req.setCharacterEncoding("UTF-8");
		
		// '응답' 데이터의 형식은 텍스트로 이루어진 html 파일이고 문자는 utf - 8 형식,
		resp.setContentType("text/html;charset=utf-8");
		
		// 요청 데이터는 대부분 하는 편이고 응답 데이터는 때에 따라서 사용한다.
		// = 아래와 같이 서블릿에서 append 등의 태그를 사용하여 html 태그를 사용할 때 
		
		System.out.println("왜 안 돼? 아니 돼!");

		// 전달 파라미터를 요청객체 req 에서 꺼내기
		String uid = req.getParameter("uid"); // <input type> 의 name Query String
		String upw = req.getParameter("upw"); // <input type> 의 name Query String
		

		// 전달 파라미터 확인(콘솔 출력)
		System.out.println("inputForm.jsp_uid = " + uid);
		System.out.println("inputForm.jsp_upw = " + upw);
		

		// 응답 데이터 구성하기
		// JSP 사용하지 않고, Servlet으로 직접 응답을 작성하기
		
		PrintWriter out = resp.getWriter();
		
		out.append("<hr>")
		.append("<h1>전달 받은 데이터</h1>")
		.append("<hr>")
		.append("<h3>아이디 :" + uid + "</h3>")
		.append("<h3>비밀번호 :" + upw + "</h3>");

		/*
		 * 이건 나중에 
		 * // 응답용 View JSP 지정하기
		 * // 응답 보내기 (포워딩)
		 */

	}

}
