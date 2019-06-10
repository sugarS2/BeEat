package beeat.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import beeat.board.model.*;


@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
			}else if(method.equals("insertRe")) {
				insertRe(request, response);
			}else if(method.equals("deleteRe")) {
				deleteRe(request, response);
			}else if(method.equals("insertReRe")) {
				insertReRe(request, response);
			}else if(method.equals("insertWindow")) {
				insertWindow(request, response);
			}else if(method.equals("updateForm")) {
				updateForm(request, response);
			}else if(method.equals("update")) {
				update(request, response);
			}else if(method.equals("delete")) {
				delete(request, response);
			}
		}else {
			list(request, response);
		}
	}
	
	//list
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardService service = BoardService.getInstance();
		ArrayList<BoardDTO> boardList = service.list();
		request.setAttribute("boardList", boardList);
		RequestDispatcher rd = request.getRequestDispatcher("board/list.jsp");
		rd.forward(request, response);
	}
	
	//insert form
	private void insertF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CategoryService categoryService = CategoryService.getInstance();
		ArrayList<CategoryDTO> categoryList = categoryService.findAll();
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
		rd.forward(request, response);
	}
	
	//insert
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardService service = BoardService.getInstance();
		//String saveDirectory = "C:/KSW/workspace/BeEat/WebContent/imgs/board";
		ServletContext sc = getServletContext();
		String saveDirectory = sc.getRealPath("/imgs/board"); // 저장될 경로(이클립스 상 절대경로)
		System.out.println("saveDirectory : " + saveDirectory);
		int maxPostSize = 5*1028*1028;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest mr = new MultipartRequest(
				request, saveDirectory, maxPostSize, encoding, policy);
		
		String b_title = mr.getParameter("b_title");
		int c_code = Integer.parseInt(mr.getParameter("c_code"));
		String b_content = mr.getParameter("b_content");
		String b_img1 = mr.getOriginalFileName("b_img1");
		String b_img2 = mr.getOriginalFileName("b_img2");
		String b_img3 = mr.getOriginalFileName("b_img3");
		String email = mr.getParameter("email");
		
		BoardDTO dto = new BoardDTO(-1, b_title, c_code, b_content, b_img1, b_img2, b_img3, null, -1, email);
		service.insert(dto);
		
		list(request, response);
	}
	
	//content
	private void content(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int b_code = Integer.parseInt(request.getParameter("b_code"));
		BoardService service = BoardService.getInstance();
		//컨텐트
		BoardDTO boardDTO = service.content(b_code);
		request.setAttribute("boardDTO", boardDTO);
		//댓글
		ArrayList<B_ReplyDTO> replyList = service.reply(b_code);
		request.setAttribute("replyList", replyList);	
		
		RequestDispatcher rd = request.getRequestDispatcher("board/content.jsp");
		rd.forward(request, response);
	}
	
	//update form
	private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int b_code = Integer.parseInt(request.getParameter("b_code"));
		System.out.println("b_code : " + b_code);
		CategoryService categoryService = CategoryService.getInstance();
		ArrayList<CategoryDTO> categoryList = categoryService.findAll();
		request.setAttribute("categoryList", categoryList);
		BoardService service = BoardService.getInstance();
		BoardDTO boardDTO = service.content(b_code);
		request.setAttribute("updateForm", boardDTO);
		RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
		rd.forward(request, response);
	}
	
	//update
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		ServletContext sc = getServletContext();
		String saveDirectory = sc.getRealPath("/imgs/board"); // 저장될 경로(이클립스 상 절대경로)
		//String saveDirectory  "C:/KSW/workspace/BeEat/WebContent/imgs/board";
		System.out.println("saveDirectory : " + saveDirectory);
		int maxPostSize = 5*1028*1028;
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest mr = new MultipartRequest(
				request, saveDirectory, maxPostSize, encoding, policy);
		
		String b_title = mr.getParameter("b_title");
		int c_code = Integer.parseInt(mr.getParameter("c_code"));
		String b_content = mr.getParameter("b_content");
		String b_img1 = mr.getOriginalFileName("b_img1");
		String b_img2 = mr.getOriginalFileName("b_img2");
		String b_img3 = mr.getOriginalFileName("b_img3");
		int b_code = Integer.parseInt(mr.getParameter("b_code"));
		
		BoardDTO dto = new BoardDTO(b_code, b_title, c_code, b_content, b_img1, b_img2, b_img3, null, -1, null);
		service.update(dto);
		
		list(request, response);
	}
	
	//delete
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int b_code = Integer.parseInt(request.getParameter("b_code"));
		BoardService service = BoardService.getInstance();
		service.delete(b_code);
		list(request, response);
	}
	
	//insert reply
	private void insertRe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int b_code = Integer.parseInt(request.getParameter("b_code"));
		String br_content = request.getParameter("br_content");
		String email = request.getParameter("email");
		B_ReplyDTO dto = new B_ReplyDTO(-1, br_content, null, -1, -1, -1, b_code, email);
		BoardService service = BoardService.getInstance();
		service.insertRe(dto);
		content(request, response);
	}
	
	//delete reply
	private void deleteRe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int br_idx = Integer.parseInt(request.getParameter("br_idx"));
		BoardService service = BoardService.getInstance();
		service.deleteRe(br_idx);
		content(request, response);
	}
	
	//reply reply
	private void insertReRe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String br_content = request.getParameter("br_content");
		System.out.println("br_content : " + br_content);
		int br_refer = Integer.parseInt(request.getParameter("br_refer"));
		int br_lev = Integer.parseInt(request.getParameter("br_lev"));
		int br_order = Integer.parseInt(request.getParameter("br_order"));
		int b_code = Integer.parseInt(request.getParameter("b_code"));
		String email = request.getParameter("email");
		B_ReplyDTO dto = new B_ReplyDTO(-1, br_content, null, br_refer, br_lev, br_order, b_code, email);
		System.out.println("br_content : " + br_content + "br_refer : " + br_refer + "br_lev : " + br_lev);
		System.out.println("b_code : " + b_code + "email : " + email);
		BoardService service = BoardService.getInstance();
		service.updateRe(br_order);
		service.insertReRe(dto);
		content(request, response);
	}
	
	//reply reply window open
	private void insertWindow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int br_idx = Integer.parseInt(request.getParameter("br_idx"));
		BoardService service = BoardService.getInstance();
		B_ReplyDTO replyContent = service.reContent(br_idx);
		request.setAttribute("replyContent", replyContent);
		RequestDispatcher rd = request.getRequestDispatcher("board/reply.jsp");
		rd.forward(request, response);
	}
}
