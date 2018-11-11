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
 * Servlet implementation class NewKuchiServlet
 */
@WebServlet("/NewKuchiServlet")
public class NewKuchiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		//セッションから口コミ情報が入っているKuchiを取り出しBeanへ格納
		HttpSession session=request.getSession();
		KuchiBean dto=new KuchiBean();
		dto = (KuchiBean)session.getAttribute("kuchi");
		int eCode=dto.geteCode();

		//kuchi_listへ新しい口コミを追加し、口コミ情報が入っているKuchiをセッションから削除する
		try(KuchiDAO dao = new KuchiDAO()){
			dao.tourokuInsert(dto);
			session.removeAttribute("kuchi");
		} catch (Exception e) {
			throw new ServletException(e);
		}
		//イベント詳細画面へ戻る
		response.sendRedirect("EventDetailGetServlet?code="+eCode);
	}

}
