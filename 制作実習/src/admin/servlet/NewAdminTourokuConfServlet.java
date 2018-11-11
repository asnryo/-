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
 * 新規管理者登録、確認を行う
 */
@WebServlet("/NewAdminTourokuConfServlet")
public class NewAdminTourokuConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAdminTourokuConfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		AdminBean adm = new AdminBean();

		//新規のとき
		String new_adm = request.getParameter("new_adm");
		if(new_adm != null) {
			//管理者IDの重複チェック
			//重複している場合、エラー確認画面に遷移する
			try(AdminDAO dao = new AdminDAO()){
				AdminBean admka =  dao.detail(request.getParameter("adm_id"));
				String admid = admka.getId();
				if(admid != null) {
					request.setAttribute("kaburi", "このIDは使われております");
					RequestDispatcher rd2 = request.getRequestDispatcher("AdminDetailServlet");
					rd2.forward(request, response);
					return;
				}
				//新規ならコードに0を入れる
				adm.setCode(1);
			}catch (Exception e) {
				// TODO: handle exception
				throw new ServletException(e);
			}
		}
		//リクエストパラメータを受け取り、DTOへ格納する準備を行う
		String adm_id = request.getParameter("adm_id");
		String adm_pw = request.getParameter("adm_pw");
		String adm_nick = request.getParameter("adm_nick");
		String adm_mail = request.getParameter("adm_mail");

		//Beensへ格納する

		adm.setId(adm_id);
		adm.setPw(adm_pw);
		adm.setNick(adm_nick);
		adm.setMail(adm_mail);

		//セッションオブジェクトの取得
		HttpSession session = request.getSession();
		//セッションに格納する
		session.setAttribute("adm", adm);

		//登録確認画面に遷移させる
		RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminInfoConf.jsp");
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
