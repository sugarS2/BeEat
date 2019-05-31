package beeat.member.controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beeat.member.model.*;


@WebServlet("/validate.do")
public class ValidateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		MemberService service = MemberService.getInstance();
		int check = service.validate(email);
		
		PrintWriter out = response.getWriter();
		if(check==1) { 
			out.println("false"); // 이미 있는 이메일(회원)
		}else {
			out.println("true"); // 유효성통과
		}
	}
}
