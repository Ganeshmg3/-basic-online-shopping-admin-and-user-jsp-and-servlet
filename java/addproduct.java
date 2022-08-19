

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
 * Servlet implementation class addproduct
 */
@WebServlet("/addproduct")
public class addproduct extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("p1");
		String b=request.getParameter("p2");
		String c=request.getParameter("p2");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bas","root","");
			Statement st=con.createStatement();
			st.executeUpdate("insert into addproduct values('"+a+"','"+b+"','"+c+"')" );
		    response.sendRedirect("adminhome.jsp");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
