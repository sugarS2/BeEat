package beeat.hotplace.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import beeat.member.model.*;
import beeat.h_reply.model.*;
import beeat.hotplace.model.*;
import beeat.loc.model.*;
import beeat.category.model.*;



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
				content(request, response);
			}else if(method.equals("updateF")) {
				updateF(request, response);
			}else if(method.equals("update")) {
				update(request, response);
			}else if(method.equals("delete")) {
				delete(request, response);
			}else if(method.equals("delete")) {
				delete(request, response);
			}else if(method.equals("findByCategory")) {
				findByCategory(request, response);
			}else if(method.equals("findByOptions")) {
				findByOptions(request, response);
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
		System.out.println("saveDirectory : " + saveDirectory);
		//String saveDirectory2 = "C:/KSW/workspace/BeEat/WebContent/imgs/hotplace";
		int maxPostSize = 5*1024*1024; // 파일 최대 사이즈 5MB로 지정
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest multi = new  MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		//MultipartRequest multi2 = new  MultipartRequest(request, saveDirectory2, maxPostSize, encoding, policy);
		
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
		
		HotPlaceDTO dto = new HotPlaceDTO(-1, h_name, c_code, loc_code, h_address, h_info, h_tel, h_time, h_menu, h_img1, h_img2, h_img3, null, 0, h_grade, email);
		
		HotPlaceService service = HotPlaceService.getInstance();
		service.insert(dto);
		response.sendRedirect("hotplace.do?method=list");
	}
	
	
	// content
	private void content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int h_code = Integer.parseInt(request.getParameter("h_code"));
		HotPlaceService hotplaceService = HotPlaceService.getInstance();
		
		Cookie[] cookies = request.getCookies();
		Cookie viewCookie = null; // 비교하기 위한 새로운 쿠키
		// 쿠키가 있을 경우
		if(cookies!=null && cookies.length>0) {
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("VIEWCOOKIE")) {
					viewCookie = cookies[i];
				}
			}
		}
		if(viewCookie==null) {
			Cookie newCookie = new Cookie("VIEWCOOKIE", "|"+h_code+"|");
			response.addCookie(newCookie);
			hotplaceService.updateReadNum(h_code); // 조회수 증가
		}else {
			String value = viewCookie.getValue();
			if(! value.contains("|"+h_code+"|")) {
				hotplaceService.updateReadNum(h_code); // 조회수 증가
			}
			if(value.indexOf("|"+h_code+"|")<0) {
				value = value + "|"+h_code+"|";
				viewCookie.setValue(value);
				response.addCookie(viewCookie);
			}
		}
		
		HotPlaceDTO hotplaceDTO = hotplaceService.findByCode(h_code);
		H_ReplyService h_replyService = H_ReplyService.getInstance();
		ArrayList<H_ReplyDTO> h_replyList = h_replyService.findByHCODE(h_code);
		int replyCount = h_replyService.countReplyByHCODE(h_code);
		
		request.setAttribute("hotplaceDTO", hotplaceDTO);
		request.setAttribute("h_replyList", h_replyList);
		request.setAttribute("replyCount", replyCount);
		RequestDispatcher rd = request.getRequestDispatcher("hotplace/content.jsp");
		rd.forward(request, response);
	}
	
	
	// updateF
	private void updateF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int h_code = Integer.parseInt(request.getParameter("h_code"));
		HotPlaceService service = HotPlaceService.getInstance();
		HotPlaceDTO hotplaceDTO = service.findByCode(h_code);
		
		CategoryService categoryService = CategoryService.getInstance();
		ArrayList<CategoryDTO> categoryList = categoryService.findAll();
		LocService locService = LocService.getInstance();
		ArrayList<LocDTO> locList = locService.findAll();
		
		request.setAttribute("hotplaceDTO", hotplaceDTO);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("locList", locList);
		RequestDispatcher rd = request.getRequestDispatcher("hotplace/update.jsp");
		rd.forward(request, response);
	}
	// update
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		String saveDirectory = sc.getRealPath("/imgs/hotplace"); // 저장될 경로(이클립스 상 절대경로)
		//String saveDirectory2 = "C:/KSW/workspace/BeEat/WebContent/imgs/hotplace";
		int maxPostSize = 5*1024*1024; // 파일 최대 사이즈 5MB로 지정
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest multi = new  MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		//MultipartRequest multi2 = new  MultipartRequest(request, saveDirectory2, maxPostSize, encoding, policy);
		
		int h_code = Integer.parseInt(multi.getParameter("h_code"));
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
		System.out.println(h_code);
		HotPlaceDTO dto = new HotPlaceDTO(h_code, h_name, c_code, loc_code, h_address, h_info, h_tel, h_time, h_menu, h_img1, h_img2, h_img3, null, 0, h_grade, email);
		
		HotPlaceService service = HotPlaceService.getInstance();
		service.update(dto);
		response.sendRedirect("hotplace.do?method=content&h_code="+h_code);
	}
	
	
	//delete
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int h_code = Integer.parseInt(request.getParameter("h_code"));
		HotPlaceService service = HotPlaceService.getInstance();
		service.delete(h_code);
		response.sendRedirect("hotplace.do?method=list");
	}
	
	
	// findByCategory
	private void findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int c_code = Integer.parseInt(request.getParameter("c_code"));
		CategoryService categoryService = CategoryService.getInstance();
		ArrayList<CategoryDTO> categoryList = categoryService.findAll();
		HotPlaceService hotplaceService = HotPlaceService.getInstance();
		ArrayList<HotPlaceDTO> hotplaceList = hotplaceService.findByCategory(c_code);
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("hotplaceList", hotplaceList);
		request.setAttribute("c_code", c_code);
		RequestDispatcher rd = request.getRequestDispatcher("hotplace/list.jsp");
		rd.forward(request, response);
	}
	
	
	// findByOptions
	private void findByOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String order = request.getParameter("order");
		int c_code = Integer.parseInt(request.getParameter("c_code"));
		System.out.println(order + ", " + request.getParameter("c_code"));
		CategoryService categoryService = CategoryService.getInstance();
		ArrayList<CategoryDTO> categoryList = categoryService.findAll();
		HotPlaceService hotplaceService = HotPlaceService.getInstance();
		ArrayList<HotPlaceDTO> hotplaceList = hotplaceService.findByOptions(order, c_code);
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("hotplaceList", hotplaceList);
		request.setAttribute("order", order);
		request.setAttribute("c_code", c_code);
		RequestDispatcher rd = request.getRequestDispatcher("hotplace/list.jsp");
		rd.forward(request, response);
	}
}
