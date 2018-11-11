package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beens.EventBean;
import dao.EventDAO;

/**
 * Servlet implementation class EventAuthenticationServlet
 */
@WebServlet("/EventAuthenticationServlet")
public class EventAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventAuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータを受け取り、DTOに格納する準備をする。
				int ev_code = Integer.parseInt(request.getParameter("ev_code"));
				String ev_name = request.getParameter("ev_name");
				String ev_des = request.getParameter("ev_des");
				String op_day = request.getParameter("op_des");
				String end_day = request.getParameter("end_day");
				String op_time = request.getParameter("op_time");
				String end_time = request.getParameter("end_time");
				String spot = request.getParameter("spot");
				String ev_img = request.getParameter("ev_img");
				String cate = request.getParameter("cate");
				String link = request.getParameter("link");

				//DTOへ格納する。登録される期限（limit）はTodoクラスではinputLimitになる。
				EventBean ev = new EventBean();

	  			ev.setCode(ev_code);
	  			ev.setName(ev_name);
	  			ev.setDes(ev_des);
	  			ev.setOpenDate(op_day);
	  			ev.setEndDate(end_day);
	  			ev.setOpenTime(op_time);
	  			ev.setEndTime(end_time);
	  			ev.setSpot(spot);
	  			ev.setImg(ev_img);
	  			ev.setCate(cate);
	  			ev.setLink(link);


				String message = "";
				try(EventDAO dao = new EventDAO()) {
					//更新または登録処理を行う
					//ev_codeが0のときは新規登録、ev_code>=1のときは更新
					if (ev_code == 0) {
						dao.tourokuInsert(ev);
						message = "タスクの新規登録が完了しました。";
					}else {
						dao.tourokuEdit(ev);
						message = "タスク[ " + ev_code + " ]の更新処理が完了しました。";
					}
					setMessage(request, message);
				}catch (Exception e) {
					throw new ServletException(e);
				}
				//編集登録完了→ログイン状態トップページ画面を表示する
				RequestDispatcher rd = request.getRequestDispatcher("AdminEventDetail.jsp");
				rd.forward(request, response);
			}
			private void setMessage(HttpServletRequest request, String message) {
		// TODO 自動生成されたメソッド・スタブ


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
