package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beens.UserBean;
import dao.UserDAO;

/**
 * Servlet implementation class UserTourokuTest
 */
@WebServlet("/UserTourokuTest")
public class UserTourokuTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTourokuTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(UserDAO dao = new UserDAO();
				Connection connection = dao.getConnection()){
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			//初めてのテストコード
			UserBean u = new UserBean();
			u.setId("testcode");
			u.setNick("2回目テスト");
			out.println("入力" +dao.tourokuInsert(u));
			dao.close();
		}catch(Exception e) {
			new ServletException(e);
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
