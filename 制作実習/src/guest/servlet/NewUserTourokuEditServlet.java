package guest.servlet;

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
 * Servlet implementation class NewUserTourokuEditServlet
 */
@WebServlet("/NewUserTourokuEditServlet")
public class NewUserTourokuEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserTourokuEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				this.doPost(request, response);
	}

	/**
	 * @param session
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		//hiddenで受け渡したリクエストパラメータを受け取り、格納する準備を行う
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_nick = request.getParameter("user_nick");
		System.out.println(user_nick);
		String user_mail = request.getParameter("user_mail");

		//UserBeanの準備
		UserBean user = new UserBean();
		//UserBeanへデータを格納
		user.setId(user_id);
		user.setPw(user_pw);
		user.setNick(user_nick);
		user.setMail(user_mail);

		try (UserDAO dao = new UserDAO()) {
			//tourokuInsertメソッドでSQLを発行して、DBにユーザー情報を登録する
			dao.tourokuInsert(user);


			//セッションの準備
			HttpSession session = request.getSession();


			//セッションにsetする
			session.setAttribute("userse", user);


		} catch (Exception e) {
			throw new ServletException(e);
		}

		//登録完了画面に遷移させる
		RequestDispatcher rd = request.getRequestDispatcher("/Gest/NewFin.jsp");
		rd.forward(request, response);
	}
}


