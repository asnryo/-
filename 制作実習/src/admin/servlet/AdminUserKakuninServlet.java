package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beens.UserBean;
import dao.UserDAO;

/**
 * Servlet implementation class AdminUserDeleteServlet
 */
@WebServlet("/AdminUserKakuninServlet")
public class AdminUserKakuninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserKakuninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramcode = request.getParameter("id");

		System.out.println(paramcode);
		try (UserDAO dao = new UserDAO()) {
			String id = paramcode;

			UserBean user = dao.detail(id);


			request.setAttribute("user", user);
		} catch (Exception e) {
			throw new ServletException(e);
		}



		RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminUserDelete.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
