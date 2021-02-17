

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedbackInsert
 */
@WebServlet("/FeedbackInsert")
public class FeedbackInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String message=request.getParameter("message");
		
		FeedBackBean fb=new FeedBackBean();
		fb.setName(name);
		fb.setMessage(message);
		PrintWriter pw=response.getWriter();
		
		FeedbackDAO dao=new FeedbackDAO();
		try {
			int i=dao.feedbackInsert(fb);
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Feedbackdisplay");
				request.setAttribute("FeedBackBean",fb);
				rd.forward(request, response);
				
			}
			else {
				pw.print("failed");
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
