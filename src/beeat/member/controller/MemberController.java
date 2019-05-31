package beeat.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method!=null) {
			if(method.equals("signupF")) {
				signupF(request, response);
			}
		}else {
			response.sendRedirect("main.do");
		}
	}
	
	
	// signF
	private void signupF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("member/signupForm.jsp");
	}
}
