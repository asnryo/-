package guest.servlet;

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
 * 新規登録処理、確認を行う
 */
@WebServlet("/NewUserConfServlet")
public class NewUserConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserConfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");

		//ユーザーIDの重複チェック
		//重複している場合、エラー確認画面に遷移する
		try(UserDAO dao = new UserDAO()){
			UserBean user = dao.detail(request.getParameter("user_id"));
			String userid = user.getId();
			if(userid != null) {
				request.setAttribute("userid", userid);
				RequestDispatcher rd = request.getRequestDispatcher("/Gest/NewTourokuError.jsp");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}

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

		//新規の為、requestに格納する
		request.setAttribute("user", user);

		//登録確認画面に遷移させる
		RequestDispatcher rd = request.getRequestDispatcher("/Gest/NewTourokuConf.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
