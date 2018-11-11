package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beens.AdminBean;

/**
 * Servlet implementation class AdminTourokuEditServlet
 */
@WebServlet("/AdminTourokuEditServlet")
public class AdminTourokuEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTourokuEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメータを受け取り、DTOへ格納する準備を行う
				request.setCharacterEncoding("UTF-8");


				String adm_id = request.getParameter("adm_id");
				System.out.println("AdminTourokuEditServlet:" + "adm_id");
				String adm_pw = request.getParameter("adm_pw");
				System.out.println("AdminTourokuEditServlet:" + "adm_pw");
				String adm_nick = request.getParameter("adm_nick");
				System.out.println("AdminTourokuEditServlet:" + "adm_nick");
				String adm_mail = request.getParameter("adm_mail");
				System.out.println("AdminTourokuEditServlet:" + "adm_mail");
				String adm_date = request.getParameter("adm_date");

				AdminBean adm = new AdminBean();


				adm.setId(adm_id);
				System.out.println(adm.getId());
				adm.setPw(adm_pw);
				System.out.println(adm.getPw());
				adm.setNick(adm_nick);
				System.out.println(adm.getNick());
				adm.setMail(adm_mail);
				System.out.println(adm.getMail());
				adm.setDate(adm_date);




				request.setAttribute("adminBean", adm);
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
