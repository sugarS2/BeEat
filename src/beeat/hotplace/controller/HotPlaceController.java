package beeat.hotplace.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import beeat.member.model.*;
import beeat.hotplace.model.*;



@WebServlet("/hotplace.do")
public class HotPlaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method!=null) {
			if(method.equals("list")) {
				list(request, response);
			}else if(method.equals("insertF")) {
				insertF(request, response);
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
		// 업종 목록 불러오기
		CategoryService categoryService = CategoryService.getInstance();
		ArrayList<CategoryDTO> categoryList = categoryService.findAll();
		HotPlaceService hotplaceService = HotPlaceService.getInstance();
		ArrayList<HotPlaceDTO> hotplaceList = hotplaceService.findAll();
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("hotplaceList", hotplaceList);
		RequestDispatcher rd = request.getRequestDispatcher("hotplace/list.jsp");
		rd.forward(request, response);
		//response.sendRedirect("hotplace/list.jsp");
	}
	
	
	// insertF
	private void insertF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 업종 목록 불러오기
		CategoryService categoryService = CategoryService.getInstance();
		ArrayList<CategoryDTO> categoryList = categoryService.findAll();
		
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher("hotplace/insert.jsp");
		rd.forward(request, response);
	}
}
