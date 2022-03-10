

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public User() {
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw =response.getWriter();
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title> USERS</title>");
		pw.print("</head>");
		pw.print("<body>");
		
		
          
          try {
        	  String url = "jdbc:mysql://127.0.0.1:3306/exe";
              String username = "root";
              String password = "12345";
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			
		try(Connection con=DriverManager.getConnection(url,username,password)){
			pw.println("Connection to ProductDB succesfull!");
			
			Statement stet=con.createStatement();
			ResultSet sr=stet.executeQuery("select * from users");
			
			while(sr.next()) {
				
				pw.print("<h1>");
				pw.write(sr.getString("uname")+"  ");
				pw.write(sr.getString("usecname")+"  ");
				pw.write(sr.getInt("age")+"  ");
				pw.write(sr.getString("address")+"  ");
				pw.write(sr.getString("phone"));
				pw.print("</h1>");
				pw.print("<hr>");
			}
		}
		} catch (Exception e) {
			
		}
          pw.print("</body>");
		pw.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
