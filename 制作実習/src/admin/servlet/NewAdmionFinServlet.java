package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beens.AdminBean;
import dao.AdminDAO;

/**
 * Servlet implementation class NewAdmionFinServlet
 */
@WebServlet("/NewAdmionFinServlet")
public class NewAdmionFinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAdmionFinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメータを受け取り、DTOへ格納する準備を行う
				String admin_id = request.getParameter("adm_id");
				System.out.println("NewAdminTourokuConfServlet:" + "adm_id");
				String admin_pw = request.getParameter("adm_pw");
				System.out.println("NewAdminTourokuConfServlet:" + "adm_pw");
				String admin_nick = request.getParameter("adm_nick");
				System.out.println("NewAdminTourokuConfServlet:" + "adm_nick");
				String admin_mail = request.getParameter("adm_mail");
				System.out.println("NewAdminTourokuConfServlet:" + "adm_mail");

				AdminBean Admin = new AdminBean();
				Admin.setId(admin_id);
				System.out.println(Admin.getId());
				Admin.setPw(admin_pw);
				System.out.println(Admin.getPw());
				Admin.setNick(admin_nick);
				System.out.println(Admin.getNick());
				Admin.setMail(admin_mail);
				System.out.println(Admin.getMail());

				try (AdminDAO dao = new AdminDAO()) {

					//if (id == 0){
					dao.tourokuInsert(Admin);
					String massage = "新規登録完了しました。";
					setMessage(request, massage);

				} catch (Exception e) {
					request.setAttribute("exception", "メールアドレス、ニックネームが重複しています");
					RequestDispatcher rd = request.getRequestDispatcher("/Admin/NewAdminTouroku.jsp");
					rd.forward(request, response);
				}

				//登録完了画面へ移行
				System.out.println("登録完了しました");
				RequestDispatcher rd = request.getRequestDispatcher("/Admin/NewAdminFin.jsp");
				rd.forward(request, response);
			}

			protected void setMessage(HttpServletRequest request, String massage) {
				request.setAttribute("massage", massage);
			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
