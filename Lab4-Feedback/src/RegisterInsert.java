

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterInsert
 */
@WebServlet("/RegisterInsert")
public class RegisterInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regno=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		
		String email=request.getParameter("email");
		long phonenumber=Integer.parseInt(request.getParameter("phonenumber"));
		String username=request.getParameter("username");
	    String password=request.getParameter("password");
		RegisterBean rb=new RegisterBean();
		rb.setRegno(regno);
		rb.setName(name);
		rb.setEmail(email);
		rb.setMobile(phonenumber);
		rb.setUsername(username);
		rb.setPassword(password);
		PrintWriter pw=response.getWriter();//response from servlet to client.
		//pw.print(regno+" "+name);
		
		

		RegisterDAO dao=new RegisterDAO();
		
		try {
		   int i=dao.registerInsert(rb);
		   
		   if(i>0)
		   {
			   
			   Cookie ck=new Cookie("usersave",username);
			    request.getRequestDispatcher("login.html").include(request, response);
			    pw.print("Registartion is done successfully");
				response.addCookie(ck);
				
			    //request.getRequestDispatcher("login.html").include(request, response);
				//pw.print("login is done successfully");
			   //RequestDispatcher rd=request.getRequestDispatcher("RegisterDisplay");
		       //request.setAttribute("RegisterBean",rb);
		       //rd.forward(request, response);
		   }
		   else {
              pw.print("registartion unsuccessfull");
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
