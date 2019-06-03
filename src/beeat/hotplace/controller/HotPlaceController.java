package beeat.hotplace.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import beeat.member.model.*;



@WebServlet("/hotplace.do")
public class HotPlaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method!=null) {
			if(method.equals("list")) {
				list(request, response);
			}else if(method.equals("insertF")) {
				//insertF(request, response);
			}else if(method.equals("insert")) {
				//insert(request, response);
			}else if(method.equals("content")) {
				//content(request, response);
			}else if(method.equals("updateF")) {
				//updateF(request, response);
			}else if(method.equals("update")) {
				//update(request, response);
			}else if(method.equals("delete")) {
				//delete(request, response);
			}
		}else {
			response.sendRedirect("main.do");
		}
	}
	
	
	// list
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("hotplace/list.jsp");
	}
	
}
