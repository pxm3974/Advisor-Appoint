package uta.mav.appoint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	private String header;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		String role = (String)session.getAttribute("role");
		if (role != null){
			if (role.equals("1")){
				header = "/WEB-INF/jsp/views/templates/advisor_header.jsp";
				}
			if (role.equals("2")){
				header = "/WEB-INF/jsp/views/templates/student_header.jsp";
				}
			if (role.equals("3")){
				header = "/WEB-INF/jsp/views/templates/admin_header.jsp";
				}
			if (role.equals("4")){
				header = "/WEB-INF/jsp/views/templates/faculty_header.jsp";
				}
			
		}
		else{
			header = "/WEB-INF/jsp/views/templates/header.jsp";
		}
		request.setAttribute("includeHeader", header);
		request.getRequestDispatcher("/WEB-INF/jsp/views/index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		String auth = (String)session.getAttribute("authenticated");
		if (auth != null){
			if (auth.equals("1")){
				header = "/WEB-INF/jsp/views/templates/loggedin_header.jsp";
				}
		}
		request.setAttribute("includeHeader", header);
		request.getRequestDispatcher("/WEB-INF/jsp/views/index.jsp").forward(request, response);
	}

}
