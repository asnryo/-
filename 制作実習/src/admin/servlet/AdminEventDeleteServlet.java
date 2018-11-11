package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beens.EventBean;
import dao.EventDAO;

/**
 * Servlet implementation class AdminEventDelete
 */
@WebServlet("/AdminEventDeleteServlet")
public class AdminEventDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int code = Integer.parseInt(request.getParameter("ev_code"));

		try(EventDAO dao = new EventDAO()){
			EventBean event = dao.detail(code);
			request.setAttribute("event", event);
			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminEventDelete.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			throw new ServletException(e);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
