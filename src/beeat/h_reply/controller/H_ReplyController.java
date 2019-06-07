package beeat.h_reply.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beeat.h_reply.model.*;


@WebServlet("/h_reply.do")
public class H_ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method!=null) {
			if(method.equals("insert")) {
				insert(request, response);
			}else if(method.equals("update")) {
				update(request, response);
			}else if(method.equals("delete")) {
				delete(request, response);
			}
		}else {
			response.sendRedirect("main.do");
		}
	}
	
	// insert
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int h_code = Integer.parseInt(request.getParameter("h_code"));
		String email = request.getParameter("email");
		String hr_content = request.getParameter("hr_content");
		H_ReplyDTO dto = new H_ReplyDTO(-1, hr_content, null, h_code, email, null);
		H_ReplyService service = H_ReplyService.getInstance();
		service.insert(dto);
		//response.sendRedirect("hotplace.do?method=content&h_code="+h_code);
	}
	
	// update
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hr_idx = Integer.parseInt(request.getParameter("hr_idx"));
		String hr_content = request.getParameter("hr_content");
		H_ReplyDTO dto = new H_ReplyDTO(hr_idx, hr_content, null, -1, null, null);
		H_ReplyService service = H_ReplyService.getInstance();
		service.update(dto);
	}
	
	// update
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hr_idx = Integer.parseInt(request.getParameter("hr_idx"));
		H_ReplyService service = H_ReplyService.getInstance();
		service.delete(hr_idx);
	}
}
