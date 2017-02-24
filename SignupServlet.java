

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
		
	        String username = request.getParameter("user");
	      
	        String password = request.getParameter("pass1");
	       
	        String firstname = request.getParameter("firstname");
	        String lastname = request.getParameter("lastname");
	        String gender = request.getParameter("gender");
	        try{
	        
	        //loading drivers for mysql
	        Class.forName("com.mysql.jdbc.Driver");

		//creating connection with the database 
	          Connection  con=DriverManager.getConnection
	                     ("jdbc:mysql://localhost:3306/kumaresanlogin","root","root");

	        PreparedStatement ps=con.prepareStatement
	                  ("insert into kumaresanlogin.signup values(?,?,?,?,?)");

	        ps.setString(1, username);
	      
	        ps.setString(2, password);
	        ps.setString(3, firstname);
		      
	        ps.setString(4, lastname);
	        ps.setString(5, gender);
	        int i=ps.executeUpdate();
	        
	          if(i>0)
	          {
	            out.println("You are sucessfully registered");
	         
				request.getRequestDispatcher("login.jsp").include(request, response);
	          }
	          con.close();
	          ps.close();
	        
	        }
	        
	        catch(Exception se)
	        {
	        	out.println("---mismatching error--");
	            se.printStackTrace();
	        }
	       }
	}


