package beeat.search.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import beeat.hotplace.model.*;
import beeat.board.model.*;
import beeat.category.model.CategoryDTO;
import beeat.category.model.CategoryService;


@WebServlet("/search.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method!=null) {
			if(method.equals("find")) {
				find(request, response);
			}else if(method.equals("search")) {
				search(request, response);
			}
		}
			
		
	}

	// find
	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		String searchText = request.getParameter("searchText");
		HotPlaceService hotplaceService = HotPlaceService.getInstance();
		ArrayList<HotPlaceDTO> hotplaceList = hotplaceService.findBySearchText(searchText);
		
		
		JSONArray array = new JSONArray();
		JSONObject obj=null;
		for(int i=0; i<hotplaceList.size(); i++) {
			obj = new JSONObject();
			obj.put("h_name", hotplaceList.get(i).getH_name());
			obj.put("c_name", hotplaceList.get(i).getC_name());
			obj.put("loc_addr1", hotplaceList.get(i).getLoc_addr1());
			obj.put("loc_addr2", hotplaceList.get(i).getLoc_addr2());
			array.add(obj);
			//array.add(hotplaceList.get(i));
		}
		PrintWriter pw = response.getWriter();
		pw.print(array);
		pw.flush();
		pw.close();
	}	
	
	
	// search
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotPlaceService hotplaceService = HotPlaceService.getInstance();
		BoardService boardService = BoardService.getInstance();
		
		String searchText = request.getParameter("searchText");
		String numStr = request.getParameter("num");
		
		ArrayList<HotPlaceDTO> hotplaceList=null;
		if(numStr!=null) {
			int num = Integer.parseInt(numStr);
			hotplaceList = hotplaceService.findBySearchText(searchText, num);
		}else {
			hotplaceList = hotplaceService.findBySearchText(searchText);
		}
		int hotplaceCount = hotplaceService.countBySearchText(searchText);
		System.out.println(hotplaceCount);
		
		ArrayList<BoardDTO> boardList = boardService.search(searchText);
		
		request.setAttribute("searchText", searchText);
		request.setAttribute("hotplaceList", hotplaceList);
		request.setAttribute("hotplaceCount", hotplaceCount);
		request.setAttribute("boardSearch", boardList);
		RequestDispatcher rd = request.getRequestDispatcher("search/list.jsp");
		rd.forward(request, response);
	}
}
