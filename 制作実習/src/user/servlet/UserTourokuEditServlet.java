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
 * Servlet implementation class AdminUserSerchServlet
 */
@WebServlet("/UserTourokuEditServlet")
public class UserTourokuEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTourokuEditServlet() {
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
		String user_id =request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_nick = request.getParameter("user_nick");
		String user_mail = request.getParameter("user_mail");


		//UserBeanの準備
		UserBean user = new UserBean();
		//UserBeanへデータを格納
		user.setId(user_id);
		user.setPw(user_pw);
		user.setNick(user_nick);
		user.setMail(user_mail);

		try(UserDAO dao = new UserDAO()) {
			//更新または登録処理を行う
			//user_dateがnullのときは新規登録、user_dateに情報があるときは更新
//			String date = request.getParameter("user_date");
//			if (date == null) {
//				dao.tourokuInsert(user);
//			}else {
				dao.tourokuEdit(user);
//			}
			//セッションの準備
			HttpSession session = request.getSession();


			//セッションにsetする
			session.setAttribute("userse", user);


		}catch (Exception e) {
			throw new ServletException(e);
		}

		//登録完了画面に遷移させる
		RequestDispatcher rd = request.getRequestDispatcher("/User/UserFin.jsp");
		rd.forward(request, response);
	}


}