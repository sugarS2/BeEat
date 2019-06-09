package beeat.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beeat.hotplace.model.*;
@WebServlet("/search.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchText = request.getParameter("searchText");
		HotPlaceService hotplaceService = HotPlaceService.getInstance();
		ArrayList<HotPlaceDTO> hotplaceList = hotplaceService.findBySearchText(searchText);
		RequestDispatcher rd = request.getRequestDispatcher("search/list.jsp");
		rd.forward(request, response);
	}
}
