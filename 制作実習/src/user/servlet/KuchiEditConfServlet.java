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

/**
 * Servlet implementation class KuchiEditConfServlet
 */
@WebServlet("/KuchiEditConfServlet")
public class KuchiEditConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		//口コミの編集内容をBeanに入れ、セッションへ格納する
		int kCode=Integer.parseInt(request.getParameter("kuchi_kCode"));
		int eCode=Integer.parseInt(request.getParameter("kuchi_eCode"));
		String des=request.getParameter("kuchi_des");
		int hoshi = Integer.parseInt(request.getParameter("hoshi"));
		KuchiBean dto=new KuchiBean();
		dto.setkCode(kCode);
		dto.setDes(des);
		dto.seteCode(eCode);
		dto.setHoshi(hoshi);
		HttpSession session = request.getSession();
		session.setAttribute("kuchi", dto);

		//口コミ編集確認画面へ遷移する
		RequestDispatcher rd=request.getRequestDispatcher("/User/KuchiEditConf.jsp");
		rd.forward(request, response);

	}

}
