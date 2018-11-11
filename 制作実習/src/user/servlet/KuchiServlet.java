package user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beens.KuchiBean;
import dao.KuchiDAO;

/**
 * Servlet implementation class KuchiServlet
 */
@WebServlet("/KuchiServlet")
public class KuchiServlet extends HttpServlet {
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

		//kuchiをセッションから取り出しBeanへ格納
		HttpSession session = request.getSession();
		KuchiBean dto = (KuchiBean)session.getAttribute("kuchi");
		int eCode = dto.geteCode();

		//口コミ編集をデータベースへ反映する
		try(KuchiDAO dao = new KuchiDAO()){
			dao.tourokuEdit(dto);
			session.removeAttribute("kuchi");
		} catch (Exception e) {
			throw new ServletException(e);
		}

		response.sendRedirect("EventDetailGetServlet?code="+eCode);
	}

}
