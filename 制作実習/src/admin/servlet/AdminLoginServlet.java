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
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(AdminDAO dao = new AdminDAO()){
			String id = request.getParameter("id");
//			System.out.println(id);
			String pass = (String)request.getParameter("pass");
			AdminBean admin = dao.detail(id);
			String pw = admin.getPw();
			if(pw == null) {
				System.out.println("idなし");
			}
			//入力パスワードがあっている時セッションを持たせる
			if(pass.equals(pw)) {
				HttpSession session = request.getSession();
				//session.setAttribute("admId", admin.getId());
				session.setAttribute("admse", admin);
				RequestDispatcher rd = request.getRequestDispatcher("AdminEventServlet");
				rd.forward(request, response);
			//違ったらトップへ戻る
			}else {
				String message = "IDかパスワードが間違っています";
				HttpSession session = request.getSession();
				session.setAttribute("message", message);
				response.sendRedirect(request.getHeader("referer"));

			}
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
