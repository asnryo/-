package user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beens.KuchiBean;
import beens.UserBean;

/**
 * Servlet implementation class NewKuchiConfServlet
 */
@WebServlet("/NewKuchiConfServlet")
public class NewKuchiConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//新規口コミをしたら確認画面へ遷移させるサーブレット
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewKuchiConfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		//入力した口コミ内容やユーザーIDをBeanへ入れてからセッションへ格納する
		HttpSession session=request.getSession();
		int eCode=Integer.parseInt(request.getParameter("kuchi_eCode"));
		String des=request.getParameter("kuchi_des");
	//	String userNick=request.getParameter("kuchi_userNick");
		int hoshi=Integer.parseInt(request.getParameter("kuchi_hoshi"));
		UserBean user = (UserBean)session.getAttribute("userse");
		//String userId=(String)session.getAttribute("id");

		KuchiBean dto=new KuchiBean();
		dto.setDes(des);
		dto.seteCode(eCode);
		//dto.setUserNick(userNick);
		dto.setHoshi(hoshi);
		dto.setUserid(user.getId());

		session.setAttribute("kuchi", dto);
		
		//口コミ入力確認画面へ遷移する
		RequestDispatcher rd=request.getRequestDispatcher("/User/NewKuchiConf.jsp");
		rd.forward(request, response);
	}

}
