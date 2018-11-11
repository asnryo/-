package guest.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beens.EventBean;
import dao.EventDAO;

/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/EventSearchServlet")
public class EventSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");

		//検索内容の格納
		EventBean search = new EventBean();

		//キーワードの内容を取得
		String keyword = request.getParameter("keyword");
		search.setName(keyword);
		System.out.println(keyword);

		//カテゴリーの選択内容を取得
		String cate = request.getParameter("cate");
		if(cate == ""|| "".equals(cate) || cate==null || cate == "null") {
			cate = "";
		}
		search.setCate(cate);
		System.out.println(cate);

		//エリアの選択内容を取得
		String spot = request.getParameter("spot");
		if(spot == ""|| "".equals(spot) || spot==null || spot == "null") {
			spot = "";
		}
		search.setSpot(spot);
		System.out.println(spot);

		//日にちを取得
		String openDate = request.getParameter("start");
		String endDate = request.getParameter("end");
		search.setOpenDate(openDate);
		search.setEndDate(endDate);

		try(EventDAO dao = new EventDAO()) {
			//検索内容の取得
			List<EventBean> list = dao.eventSearch(search);
			request.setAttribute("eventSearch", list);

		}catch(Exception e) {
			throw new ServletException(e);
		}
		RequestDispatcher rd = request.getRequestDispatcher("Gest/SearchList.jsp");
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
