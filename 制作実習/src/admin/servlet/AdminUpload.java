package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beens.EventBean;
import dao.EventDAO;

/**
 * Servlet implementation class AdminUpload
 */
@WebServlet("/AdminUpload")
@MultipartConfig(location="C:/pleiades/workspace-web/team0/WebContent/img")
public class AdminUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			EventBean ev = (EventBean)session.getAttribute("ev");

			Part part = request.getPart("img");

			String filename = null;
			for(String cd : part.getHeader("Content-Disposition").split(";")) {
				cd = cd.trim();
				log(cd);

				if(cd.startsWith("filename")) {

					filename = cd.substring(cd.indexOf("=") + 1).trim().replace("\"", "");
					log("upload file:" + filename);
					break;
				}
			}




			String message  = null;
			if(filename != null) {
				log(">> file write start");

				filename = filename.replace("\\", "/");

				int pos = filename.lastIndexOf("/");
				if(pos >= 0) {
					filename = filename.substring(pos + 1);

				}
				log("filename :" + filename);
				part.write(filename);
				log("   complete!");
				message = "[" + filename + "]のアップロードが完了しました";
				//Beanにimgを追加
				ev.setImg(filename);
			}else {
				log("upload filename is blank");
				message="アップロードが失敗しました";

			}


			try(EventDAO dao = new EventDAO()) {

				//更新または登録処理を行う
				//ev.codeが0の時新規それ以外は編集

				if (ev.getCode() == 0) {
					dao.tourokuInsert(ev);
					message = "イベントの新規登録が完了しました。";
				}else {
					dao.tourokuEdit(ev);
					message = "イベント[ " + ev.getName() + " ]の更新処理が完了しました。";
				}

			}catch (Exception e) {
				throw new ServletException(e);
			}
			request.setAttribute("message", message);
			//編集登録完了→ログイン状態トップページ画面を表示する
			session.removeAttribute("ev");
			RequestDispatcher rd = request.getRequestDispatcher("AdminEventServlet");
			rd.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			//エラーやファイルがなかったら戻る
			response.sendRedirect(request.getHeader("referer"));
		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
