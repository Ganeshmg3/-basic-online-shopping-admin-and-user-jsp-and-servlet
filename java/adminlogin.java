

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	String a=request.getParameter("n1");
	String b=request.getParameter("n2");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bas","root","");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from admin where name='"+a+"'  and password='"+b+"' ");
	if(rs.next())
	{
		response.sendRedirect("adminhome.jsp");
	}
	else
	{
		response.sendRedirect("adminlogin.jsp");
	}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	

}
