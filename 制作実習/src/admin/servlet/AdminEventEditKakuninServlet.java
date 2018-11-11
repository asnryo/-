package admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beens.EventBean;

/**
 * Servlet implementation class AdminEventEditKakuninServlet
 */
@WebServlet("/AdminEventEditKakuninServlet")
public class AdminEventEditKakuninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEventEditKakuninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.setAttribute("ev_code", request.getAttribute("ev_code"));
//		request.setAttribute("ev_name", request.getAttribute("ev_name"));
//		request.setAttribute("ev_img", request.getAttribute("ev_img"));
//		request.setAttribute("ev_des", request.getAttribute("ev_des"));
//		request.setAttribute("ev_openDate", request.getAttribute("ev_openDate"));
//		request.setAttribute("ev_endDate", request.getAttribute("ev_endDate"));
//		request.setAttribute("ev_openTime", request.getAttribute("ev_endTime"));
//		request.setAttribute("ev_spot", request.getAttribute("ev_spot"));
		request.setCharacterEncoding("UTF-8");
		EventBean event = new EventBean();
		event.setCode(Integer.parseInt(request.getParameter("ev_code")));
		System.out.println(event.getCode());
		event.setName(request.getParameter("ev_name"));
		System.out.println(event.getName());
		event.setDes(request.getParameter("ev_des"));
		event.setImg(request.getParameter("ev_img"));
		event.setOpenDate(request.getParameter("open_date"));
		event.setEndDate(request.getParameter("end_date"));
		event.setOpenTime(request.getParameter("open_time"));
		event.setEndTime(request.getParameter("end_time"));
		event.setSpot(request.getParameter("spot"));
		event.setCate(request.getParameter("cate"));

		HttpSession session = request.getSession();
		session.setAttribute("ev", event);

		//画像の取得
//		Part part = request.getPart("img");
//		//画像があるならファイルネームの取得
//		if(part != null) {
//			String filename = null;
//			for(String cd : part.getHeader("Content-Disposition").split(";")) {
//				cd = cd.trim();
//				log(cd);
//
//				if(cd.startsWith("filename")) {
//
//					filename = cd.substring(cd.indexOf("=") + 1).trim().replace("\"", "");
//					log("upload file:" + filename);
//					break;
//				}
//			}
//			session.setAttribute("filename", filename);
//		}
//		session.setAttribute("part", part);

		request.getRequestDispatcher("/Admin/AdminEventEditConf.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
