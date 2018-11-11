package user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beens.UserBean;

/**
 * ユーザー登録更新処理、確認を行う
 */
@WebServlet("/UserConfServlet")
public class UserConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserConfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//文字化け対策
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータを受け取り、DTOへ格納する準備を行う
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_nick = request.getParameter("user_nick");
		String user_mail = request.getParameter("user_mail");

		//DAOへ格納する
		UserBean user = new UserBean();

		user.setId(user_id);
		user.setPw(user_pw);
		user.setNick(user_nick);
		user.setMail(user_mail);

		//更新の為、requestに格納する
		request.setAttribute("userse", user);

		//更新内容確認画面に遷移させる
		RequestDispatcher rd = request.getRequestDispatcher("/User/TourokuConf.jsp");
		rd.forward(request, response);

	}
}
