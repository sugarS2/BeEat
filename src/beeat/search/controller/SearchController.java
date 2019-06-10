package beeat.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beeat.hotplace.model.*;
import beeat.board.model.*;
@WebServlet("/search.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchText = request.getParameter("searchText");
		HotPlaceService hotplaceService = HotPlaceService.getInstance();
		ArrayList<HotPlaceDTO> hotplaceList = hotplaceService.findBySearchText(searchText);
		BoardService boardService = BoardService.getInstance();
		ArrayList<BoardDTO> boardList = boardService.search(searchText);
		
		request.setAttribute("hotplaceList", hotplaceList);
		request.setAttribute("boardSearch", boardList);
		RequestDispatcher rd = request.getRequestDispatcher("search/list.jsp");
		rd.forward(request, response);
	}
}
