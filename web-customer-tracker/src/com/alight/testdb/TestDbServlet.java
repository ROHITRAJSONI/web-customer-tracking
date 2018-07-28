package com.alight.testdb;

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

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		// Setup connection variable
		String username="springstudent";
		String password="springstudent";
		
		String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out=response.getWriter();
			out.println("Connecting to a database : "+url);
			Class.forName(driver);
				
			Connection connection = DriverManager.getConnection(url,username,password);
			out.println("Connetion Successful.");
			Statement createStatement = connection.createStatement();
			ResultSet executeQuery = createStatement.executeQuery("Select *from customer");
			while(executeQuery.next())
			{
				out.println(executeQuery.getInt("id"));
			}
			connection.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException();
		}
	}
}
