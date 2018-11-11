package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class AdminDeleteConf
 */
@WebServlet("/AdminDeleteConf")
public class AdminDeleteConf extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteConf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("id");

		try (UserDAO dao = new UserDAO()) {

			 dao.delete(userid);

		}catch (NullPointerException e) {
			// TODO: handle exception
			String message = "削除に失敗しました";
			request.setAttribute("message", message);
			response.sendRedirect("AdminSerchServlet");


		} catch (Exception e) {
			throw new ServletException(e);
		}
		setMessage(request,"id[ " + userid + " ]の削除処理が完了しました");


		RequestDispatcher rd = request.getRequestDispatcher("AdminList.jsp");
		rd.forward(request, response);
	}
		protected void setMessage(HttpServletRequest request, String message) {
			request.setAttribute("message", message);
	}
	}


