

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.BreakIterator;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
		
	        String name = request.getParameter("uname");
	      
	        String pass = request.getParameter("psw");
	       
	        
	        try{
	        
	        //loading drivers for mysql
	        Class.forName("com.mysql.jdbc.Driver");

		//creating connection with the database 
	          Connection  con=DriverManager.getConnection
	                     ("jdbc:mysql://localhost:3306/kumaresanlogin","root","root");

	        PreparedStatement ps=con.prepareStatement("select username, password from kumaresanlogin.signup where username =? and password=?");

	        ps.setString(1, name);
	      
	        ps.setString(2, pass);
	        ResultSet rs=ps.executeQuery();
	        
	          if(rs.next()==true)
	          {
	            out.println("You are sucessfully loggedin");
	            HttpSession session=request.getSession();
				session.setAttribute("student","true");
				request.getRequestDispatcher("student.jsp").include(request, response);
	            
	          }
	          else{
	        	  out.println("user name(or) password is incorrect");
	        	 
	        	
					request.getRequestDispatcher("signup.jsp").include(request, response);

	        	      
	        }
	          con.close();
	          ps.close();
	          rs.close();
	        }
	        catch(Exception se)
	        {
	            se.printStackTrace();
	        }
	}
}