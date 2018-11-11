package user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beens.UserBean;
import dao.UserDAO;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		//Userのログインの可否を判断する
		try(UserDAO dao = new UserDAO()){
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			UserBean user = dao.detail(id);
			String pw = user.getPw();
			if(pw == null) {
				System.out.println("idなし");
			}
			if(pass.equals(pw)) {
				HttpSession session = request.getSession();
				session.setAttribute("userse", user);

				System.out.println(session.getAttribute("userse.nick"));


				RequestDispatcher rd = request.getRequestDispatcher("UserEventServlet");
				rd.forward(request, response);
			}else {
		//UserIdやUserPwが一致しなくてもエラーjspへ遷移する
				RequestDispatcher rd = request.getRequestDispatcher("User/UserLoginError.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}

	}

}
