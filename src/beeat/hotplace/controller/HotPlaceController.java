package beeat.hotplace.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

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
				insert(request, response);
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
		CategoryService categoryService = CategoryService.getInstance();
		ArrayList<CategoryDTO> categoryList = categoryService.findAll();
		HotPlaceService hotplaceService = HotPlaceService.getInstance();
		ArrayList<HotPlaceDTO> hotplaceList = hotplaceService.findAll();
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("hotplaceList", hotplaceList);
		RequestDispatcher rd = request.getRequestDispatcher("hotplace/list.jsp");
		rd.forward(request, response);
	}
	
	
	// insertF
	private void insertF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService categoryService = CategoryService.getInstance();
		ArrayList<CategoryDTO> categoryList = categoryService.findAll();
		LocService locService = LocService.getInstance();
		ArrayList<LocDTO> locList = locService.findAll();
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("locList", locList);
		RequestDispatcher rd = request.getRequestDispatcher("hotplace/insert.jsp");
		rd.forward(request, response);
	}
	// insert
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String saveDirectory = sc.getRealPath("/imgs/hotplace"); // 저장될 경로(이클립스 상 절대경로)
		System.out.println(saveDirectory);
		int maxPostSize = 5*1024*1024; // 파일 최대 사이즈 5MB로 지정
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest multi = new  MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		
		String h_name = multi.getParameter("h_name");
		int c_code = Integer.parseInt(multi.getParameter("c_code"));
		int loc_code = Integer.parseInt(multi.getParameter("loc_code"));
		String h_address = multi.getParameter("h_address");
		String h_info = multi.getParameter("h_info");
		String h_tel = multi.getParameter("h_tel");
		String h_time = multi.getParameter("h_time");
		String h_menu = multi.getParameter("h_menu");
		String h_img1 = multi.getOriginalFileName("h_img1");
		String h_img2 = multi.getOriginalFileName("h_img2");
		String h_img3 = multi.getOriginalFileName("h_img3");
		float h_grade = Float.parseFloat(multi.getParameter("h_grade"));
		String email = multi.getParameter("email");
		
		HotPlaceDTO dto = new HotPlaceDTO(-1, h_name, c_code, loc_code, h_address, h_info, h_tel, h_time, h_menu, h_img1, h_img2, h_img3, 0, h_grade, email);
		
		HotPlaceService service = HotPlaceService.getInstance();
		//service.insert(dto);
		
		/*
		 * System.out.println("h_name : " + h_name + ", c_code : "+ c_code +
		 * ", loc_code : "+ loc_code); System.out.println("h_address : " + h_address +
		 * ", h_info : "+ h_info + ", h_tel : "+ h_tel); System.out.println("h_time : "
		 * + h_time + ", h_menu : "+ h_menu); System.out.println("h_img1 : " + h_img1 +
		 * ", h_img2 : "+ h_img2 + ", h_img3 : "+ h_img3);
		 * System.out.println("h_grade : "+ h_grade+ ", email : "+ email);
		 */
		
	}
}
