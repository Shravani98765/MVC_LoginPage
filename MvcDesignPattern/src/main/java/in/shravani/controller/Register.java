package in.shravani.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.shravani.dbcon.DbConnection;

@WebServlet("/regForm")

public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		String myname=req.getParameter("name1");
		String myemail=req.getParameter("email1");
		String mypass=req.getParameter("pass1");
		String mycity=req.getParameter("city1");
		
		try 
		{
			Connection con=DbConnection.getConnection();
			String insert_sql_query="INSERT INTO register VALUES(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(insert_sql_query);
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, mycity);
			int count=ps.executeUpdate();
			if(count>0) {
				out.println("<h3 style='color:green'> Registered Successfully </h3>");
				RequestDispatcher rd=req.getRequestDispatcher("/login.html");
				rd.include(req,  resp);
			}
			else {
				out.println("<h3 style='color:red'> User not registered due to some error </h3>");
				RequestDispatcher rd=req.getRequestDispatcher("/register.html");
				rd.include(req,  resp);
			}
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	}