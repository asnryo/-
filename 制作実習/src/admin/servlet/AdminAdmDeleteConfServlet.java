package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beens.AdminBean;
import dao.AdminDAO;

/**
 * Servlet implementation class AdminAdmDeleteConfServlet
 */
@WebServlet("/AdminAdmDeleteConfServlet")
public class AdminAdmDeleteConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		AdminBean admin;
		try(AdminDAO dao=new AdminDAO()){
			admin=dao.detail(id);
		}catch(Exception e) {
			throw new ServletException(e);
		}
		request.setAttribute("admin", admin);
		RequestDispatcher rd=request.getRequestDispatcher("Admin/AdminDelete.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
