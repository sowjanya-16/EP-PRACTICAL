

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
 * Servlet implementation class LoginInsert
 */
@WebServlet("/LoginInsert")
public class LoginInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
	    String password=request.getParameter("password");
	   
		PrintWriter pw=response.getWriter();
		
		//PrintWriter pw=response.getWriter();//response from servlet to client.
		//pw.print(regno+" "+name);
	    RegisterDAO dao=new RegisterDAO();
		try {
		   boolean res=dao.loginUser(username, password);
		   if(res==true)
		   {
			   pw.print("Logged in successfully");
		   }
		   else
		   {
			   pw.print("Invalid credentials");
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

