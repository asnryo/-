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
 * Servlet implementation class UserEditTest
 */
@WebServlet("/UserEditTest")
public class UserEditTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditTest() {
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
			//編集
			UserBean u = new UserBean();
			u.setId("henkoucode");
			u.setNick("テストからの変更");
			u.setPw("henkou");
			u.setMail("aaa");
			u.setCode(5);
			out.println("編集" +dao.tourokuEdit(u));
			dao.close();
		}catch(Exception e) {
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
