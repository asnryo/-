package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beens.EventBean;
import dao.EventDAO;

/**
 * イベント編集フォワード
 */
@WebServlet("/AdminEventEditForwardServlet")

public class AdminEventEditForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEventEditForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String message  = null;
		EventBean ev = (EventBean)session.getAttribute("ev");



				System.out.println(ev.getCode());

				try(EventDAO dao = new EventDAO()) {

					//更新または登録処理を行う
					//ev.codeが0の時新規それ以外は編集

					if (ev.getCode() == 0) {
						dao.tourokuInsert(ev);
						message = "イベントの新規登録が完了しました。";
					}else {
						dao.tourokuEdit(ev);
						message = "イベント[ " + ev.getName() + " ]の更新処理が完了しました。";
					}
					setMessage(request, message);
				}catch (Exception e) {
					throw new ServletException(e);
				}
				//編集登録完了→ログイン状態トップページ画面を表示する
				session.removeAttribute("ev");
				RequestDispatcher rd = request.getRequestDispatcher("AdminEventServlet");
				rd.forward(request, response);
			}




	private void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
