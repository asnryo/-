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
 * Servlet implementation class TaikaiConfServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//日本語パラメータの指定
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータを受け取り、DTOに格納する準備をする。
//		String user_id =request.getParameter("user_id");
/*		String user_pw = request.getParameter("user_pw");
		String user_nick = request.getParameter("user_nick");
		String user_mail = request.getParameter("user_mail");
*/
		HttpSession session = request.getSession();

		//UserBeanの準備
		UserBean user =  (UserBean)session.getAttribute("userse");
System.out.println(user.getId());

		//UserBeanへデータを格納
	/*	user.setPw(user_pw);
		user.setNick(user_nick);
		user.setMail(user_mail);*/

//		HttpSession session = request.getSession(true);
//		String id = (String)session.getAttribute("id");
		try(UserDAO dao = new UserDAO()){
			dao.delete(user.getId());

			//削除の為に保持していたセッションを破棄する
			session.removeAttribute("userse");

			RequestDispatcher rd = request.getRequestDispatcher("/User/DeleteFin.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}

}
