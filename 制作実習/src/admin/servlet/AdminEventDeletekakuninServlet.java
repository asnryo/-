package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventDAO;

/**
 * Servlet implementation class AdminEventDeletekakuninServlet
 */
@WebServlet("/AdminEventDeletekakuninServlet")
public class AdminEventDeletekakuninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEventDeletekakuninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }public void doGet(HttpServletRequest request,HttpServletResponse response)
        		 throws IOException, ServletException
        		 {
				this.doPost(request, response);
        		 }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

    		int ev_code = Integer.parseInt(request.getParameter("ev_code"));
    		try (EventDAO dao = new EventDAO()) {

    			 dao.delete(ev_code);


    		} catch (Exception e) {
    			throw new ServletException(e);
    		}
    		setMessage(request,"ev_code[ " + ev_code + " ]の削除処理が完了しました");


    		RequestDispatcher rd = request.getRequestDispatcher("AdminEventServlet");
    		rd.forward(request, response);
    	}
    		protected void setMessage(HttpServletRequest request, String message) {
    			request.setAttribute("message", message);
    	}
    }