package form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamTestServlet
 */

@WebServlet("/param")
public class ParamTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/param - doGet ReQuest");
		
		String data1 = req.getParameter("data1");
		System.out.println("data1 = " + data1);
		
		String data2 = req.getParameter("data2");
		System.out.println("data2 = " + data2);
		
		resp.getWriter().println("<h1>data1 : " + data1 + "</h1>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	
	}

}
