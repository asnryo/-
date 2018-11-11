package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beens.AdminBean;
import dao.AdminDAO;

/**
 * Servlet implementation class AdminAdmRegisterServlet
 */
@WebServlet("/AdminAdmRegisterServlet")
public class AdminAdmRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdmRegisterServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//日本語パラメータの指定
		request.setCharacterEncoding("UTF-8");

		//入力時にsetしたセッション情報を取得する
		HttpSession session = request.getSession();

		//セッションに格納したデータを受け取り、DTOへ格納する準備を行う
		AdminBean adm = (AdminBean)session.getAttribute("adm");

		try(AdminDAO dao = new AdminDAO()){
			//新規登録の場合
			if(adm.getCode() == 1) {
				//tourokuInsertメソッドでSQLを発行して、DBにユーザー情報を登録する
				dao.tourokuInsert(adm);
			}else {
				//編集の場合
				dao.tourokuEdit(adm);
				request.setAttribute("hensyu", adm.getId()+"の編集が完了しました");
			}

			AdminBean newadm = dao.detail(adm.getId());
			request.setAttribute("newadmnick", newadm.getNick());
			//登録の為に保持していたセッションを破棄する
			session.removeAttribute("adm");

		}catch(Exception e) {
			throw new ServletException(e);
		}

		//登録完了画面に遷移させる
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/NewAdminFin.jsp");
		rd.forward(request, response);
		}
}

