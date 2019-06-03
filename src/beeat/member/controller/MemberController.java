package beeat.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import beeat.member.model.*;



@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method!=null) {
			if(method.equals("signupF")) {
				signupF(request, response);
			}else if(method.equals("signup")) {
				signup(request, response);
			}else if(method.equals("signinF")) {
				signinF(request, response);
			}else if(method.equals("signin")) {
				signin(request, response);
			}else if(method.equals("logout")) {
				logout(request, response);
			}
		}else {
			response.sendRedirect("main.do");
		}
	}
	
	
	// signupF
	private void signupF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("member/signup.jsp");
	}
	// signup
	private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		MemberDTO dto = new MemberDTO(email, name, pwd);
		System.out.println(email + " , " + name + " , " + pwd);
		MemberService service = MemberService.getInstance();
		service.signup(dto);
		response.sendRedirect("main.do");
	}
	
	
	// signinF
	private void signinF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("member/signin.jsp");
	}
	// signin
	private void signin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		System.out.println(email + " , " + pwd);
		MemberDTO dto = new MemberDTO(email, null, pwd);
		MemberService service = MemberService.getInstance();
		int check = service.signin(dto);
		if(check==1) { // 로그인 성공 시 
			HttpSession session = request.getSession();
			session.setAttribute("dto", dto);
			out.write("true");
		}else { // 로그인 실패시 
			out.write("false");
		}
	}	
	
	
	// logout
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("main.do");
	}	
}
