

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterDisplay
 */
@WebServlet("/RegisterDisplay")
public class RegisterDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RegisterBean rb=(RegisterBean) request.getAttribute("RegisterBean");
		 PrintWriter pw=response.getWriter();
		 pw.print("Welcome"+"  "+rb.getName());
	}

}
