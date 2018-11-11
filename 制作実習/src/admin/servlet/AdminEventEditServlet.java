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
 * Servlet implementation class AdminEventEditServlet
 */
@WebServlet("/AdminEventEditServlet")
public class AdminEventEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEventEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		int code = Integer.parseInt(request.getParameter("ev_code"));

		try(EventDAO dao = new EventDAO()){
			EventBean event = dao.detail(code);
			request.setAttribute("event", event);
			request.setAttribute("filename", request.getAttribute("filename"));
			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminEventEdit.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
//			RequestDispatcher rd = request.getRequestDispatcher("AdminEventServlet");
//			rd.forward(request, response);
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
