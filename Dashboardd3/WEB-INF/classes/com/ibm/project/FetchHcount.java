package com.ibm.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.sql.*;

import org.apache.wink.common.internal.providers.entity.csv.CsvWriter;


/**
 * Servlet implementation class FetchInfo
 */
public class FetchHcount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	// before we open the file check to see if it already exists
	
	
	public static final String COMMA_DELIMITER = ",";
	public static final String next_line = "\n";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchHcount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageLoad = null;
		//jdbc connecting code
		//FileWriter acceptFileWriter = null;
	
		try{  
			
		
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/padash","root","Welcome1");  
			//here sonoo is database name, root is username and password  
			//where SUBSTRING(as_of_Date, 1, 4) in ( YEAR( CURDATE()) , YEAR( CURDATE()) -1 )
			Statement stmt1=con.createStatement();  
			ResultSet rs=stmt1.executeQuery("select SUBSTRING(as_of_Date, 1, 4) as year,SUBSTRING(as_of_Date, 6, 2) AS month,sum(`count(Emp_name)`) emp_count from padash.table_pir_account_level group by SUBSTRING(as_of_Date, 1, 4),SUBSTRING(as_of_Date, 6, 2) order by as_of_Date desc");  
			CreateCSV r = new CreateCSV();
			r.fillSheet3(rs,con,"Hcountyoy");
			
		
			
			System.out.println("*****************DATA LOADED2*****************");
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
			
			response.sendRedirect("Hcount.html");
		}
		
			
			 
		
		// TODO Auto-generated method stub
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
