

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userreg
 */
@WebServlet("/userreg")
public class userreg extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("n1");
		String b=request.getParameter("n2");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bas","root","");
			Statement st=con.createStatement();
			st.executeQuery("insert into userreg values('"+a+"','"+b+"') ");
			response.sendRedirect("userhome.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
