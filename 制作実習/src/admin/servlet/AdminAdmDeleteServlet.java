package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;

/**
 * Servlet implementation class AdminUserDeleteServlet
 */
@WebServlet("/AdminAdmDeleteServlet")
public class AdminAdmDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdmDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }public void doGet(HttpServletRequest request,HttpServletResponse response)
        		 throws IOException, ServletException
        		 {
				this.doPost(request, response);
        		 }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

    		String adminid = request.getParameter("id");

    		try (AdminDAO dao = new AdminDAO()) {

    			 dao.delete(adminid);


    		} catch (Exception e) {
    			throw new ServletException(e);
    		}
    		setMessage(request,"id[ " + adminid + " ]の削除処理が完了しました");


    		RequestDispatcher rd = request.getRequestDispatcher("AdminSerchServlet");
    		rd.forward(request, response);
    	}
    		protected void setMessage(HttpServletRequest request, String message) {
    			request.setAttribute("message", message);
    	}
    }