package user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beens.EventBean;
import beens.KuchiBean;
import dao.EventDAO;
import dao.KuchiDAO;

/**
 * Servlet implementation class EventDetailGetServlet
 */
@WebServlet("/EventDetailGetServlet")
public class EventDetailGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//セッションを入れてみる
		HttpSession session = request.getSession();
		session.setAttribute("id", session.getAttribute("id"));

		//リクエストパラメータから表示するイベントコードを取得する
		String paramCode=request.getParameter("code");
//		String paramCode = "1";
		EventBean event;
		//ev_listからイベント情報を取得する
		try(EventDAO dao=new EventDAO()){
			int code=Integer.parseInt(paramCode);
			event=dao.detail(code);
			request.setAttribute("event",event);
		}catch(Exception e) {
			throw new ServletException(e);
		}

		//kuchi_listからイベントコードを指定して口コミ情報を取得する
		try(KuchiDAO dao = new KuchiDAO()){
			int code=Integer.parseInt(paramCode);
			List<KuchiBean> kuchi=dao.kuchiList(code);
			request.setAttribute("kuchi",kuchi);
		}catch(Exception e) {
			throw new ServletException(e);
		}

		//eventとkuchiをリクエストへ格納したのち、イベント詳細画面へ遷移
		RequestDispatcher rd=request.getRequestDispatcher("/User/EventDetail.jsp");
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
