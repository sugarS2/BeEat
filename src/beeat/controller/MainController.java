package beeat.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import beeat.hotplace.model.*;
@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotPlaceService hotplaceService = HotPlaceService.getInstance();
		ArrayList<HotPlaceDTO> hotplaceList = hotplaceService.findTop3ByReadNum();
		request.setAttribute("hotplaceList", hotplaceList);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}
}
