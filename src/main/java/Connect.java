

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/userCon")
public class Connect extends HttpServlet {
	
       

    public Connect() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter writer = response.getWriter();
	        try{
	            String url = "jdbc:mysql://127.0.0.1:3306/exe";
	            String username = "root";
	            String password = "12345";
	            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
	            try (Connection conn = DriverManager.getConnection(url, username, password)){
	                  
	                writer.println("Connection to ProductDB succesfull!");
	                
	                Statement stet =conn.createStatement();
	                ResultSet res =stet.executeQuery("select * from users ");
	                while(res.next()) {
	                writer.println("--------------------------------------------------------------------------------------------------------------");	
	                writer.write("|"+res.getString("uname")+" || ");
	                writer.write(res.getString("usecname")+" || ");
	                writer.write(res.getInt("age")+" || ");
	                writer.write(res.getString("address")+" || ");
	                writer.write(res.getString("phone")+" || \n");
	                }
	                stet.close();
	            }
	            
	        }
	        catch(Exception ex){
	            writer.println("Connection failed...");
	            writer.println(ex);
	        }
	        finally {
	            writer.close();
	        }
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
