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
 * ユーザー削除処理行う
 */
@WebServlet("/TaikaiConfServlet")
public class TaikaiConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaikaiConfServlet() {
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
		//文字化け対策
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータを受け取り、DTOへ格納する準備を行う
		String user_id = request.getParameter("user_id");

		String user_nick = request.getParameter("user_nick");

		//DAOへ格納する
		UserBean user = new UserBean();

		user.setId(user_id);
		System.out.println(user_id);
		user.setNick(user_nick);
		System.out.println(user_nick);

		//削除の為、requestに格納する
		request.setAttribute("userse", user);

		//削除内容確認画面に遷移させる
		RequestDispatcher rd = request.getRequestDispatcher("/User/TourokuTaikai.jsp");
		rd.forward(request, response);

	}
}

