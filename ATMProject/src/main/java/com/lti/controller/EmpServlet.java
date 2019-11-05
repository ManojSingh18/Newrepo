package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid=request.getParameter("empid");
		String ename=request.getParameter("ename");
		response.setContentType("text/html");  
		PrintWriter out= response.getWriter();  

		try{  
			  System.out.println("success1");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			  System.out.println("success2");
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@192.168.100.118:1521:XE","hr","hr");  
			      System.out.println("success3");
			
			      //InputStream
			      
			      PreparedStatement ps=con.prepareStatement(  
					"insert into Employee values(?,?)");  
					  System.out.println("connection established!!!");
					ps.setString(1,eid);  
					ps.setString(2,ename);  
					  
					
					int i=ps.executeUpdate();  
					if(i>0)  
					{
						
					out.print("You are successfully registered...");  
				
					System.out.println("Success");
					}
					else
					{
						response.sendRedirect("index.jsp");
					}
					con.close();
					
		}
		

		
		catch(Exception e)
		
		{		System.out.println(e);
		}  
		
        
		
		//@SuppressWarnings
		}  
		
	}


