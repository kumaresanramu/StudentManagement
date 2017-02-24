

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
		
	        String name = request.getParameter("name");
	      
	        String age = request.getParameter("age");
	        String address = request.getParameter("address");
	        String phoneno = request.getParameter("phno");
	        String eid = request.getParameter("eid");
	        String studentno = request.getParameter("stdno");
	        String gender = request.getParameter("gender");
	        try{
	        
	        //loading drivers for mysql
	        Class.forName("com.mysql.jdbc.Driver");

		//creating connection with the database 
	          Connection  con=DriverManager.getConnection
	                     ("jdbc:mysql://localhost:3306/kumaresanlogin","root","root");

	        PreparedStatement ps=con.prepareStatement
	                  ("insert into kumaresanlogin.student values(?,?,?,?,?,?,?)");

	        ps.setString(1, name);
	      
	        ps.setString(2, age);
	        ps.setString(3, address);
		      
	        ps.setString(4, phoneno);
	        ps.setString(5, eid);
	       
	        ps.setString(6, studentno);
	        ps.setString(7, gender);
	    
	        int i=ps.executeUpdate();
	        
	          if(i>0)
	        {
	        	  out.println("your details successfully added!!!");
	        	  HttpSession session=request.getSession();
					session.setAttribute("student","true");
					request.getRequestDispatcher("student.jsp").include(request, response);
	           
	            
	          }
	          else{
	        	  out.println("please re_enter details");
	        	
					request.getRequestDispatcher("student.jsp").include(request, response);
	          }
	          con.close();
	          ps.close();
	        
	        }
	        catch(Exception se)
	        {
	            se.printStackTrace();
	        }
	}

}
