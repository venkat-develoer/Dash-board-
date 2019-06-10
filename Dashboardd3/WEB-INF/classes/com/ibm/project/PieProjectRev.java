package com.ibm.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.sql.*;

import org.apache.wink.common.internal.providers.entity.csv.CsvWriter;


/**
 * Servlet implementation class FetchInfo
 */
public class PieProjectRev extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	// before we open the file check to see if it already exists
	
	
	public static final String COMMA_DELIMITER = ",";
	public static final String next_line = "\n";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PieProjectRev() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//jdbc connecting code
		//FileWriter acceptFileWriter = null;

		try{  
			
			Logger log = Logger.getLogger("myApp");
			log.setLevel(Level.ALL);
			log.info("initializing - trying to load configuration file ...");
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/padash","root","Welcome1");  
			//here sonoo is database name, root is username and password  
			Statement stmt1=con.createStatement();  
			ResultSet rs=stmt1.executeQuery("SELECT cy_year,ROUND(`sum(``CY_Jan_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Feb_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Mar_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Apr_Cumulative_Rev``)`,2),ROUND(`sum(``CY_May_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jun_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jul_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Aug_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Sep_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Oct_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Nov_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Dec_Cumulative_Rev``)`,2) FROM padash.table_rev_cost_pa_level order by cy_year desc LIMIT 3;");  
			CreateCSV r = new CreateCSV();
			r.fillSheet1(rs,con,"REVENUEyoy");
			
		//	System.out.println("part1 completed");
			Statement stmt2=con.createStatement();  
			ResultSet rs1=stmt2.executeQuery("SELECT cy_year,ROUND(`CY_Jan_Cumulative_GP`*100,2),ROUND(`CY_Feb_Cumulative_GP`*100,2),ROUND(`CY_Mar_Cumulative_GP`*100,2),ROUND(`CY_Apr_Cumulative_GP`*100,2),ROUND(`CY_May_Cumulative_GP`*100,2),ROUND(`CY_Jun_Cumulative_GP`*100,2),ROUND(`CY_Jul_Cumulative_GP`*100,2),ROUND(`CY_Aug_Cumulative_GP`*100,2),ROUND(`CY_Sep_Cumulative_GP`*100,2),ROUND(`CY_Oct_Cumulative_GP`*100,2),ROUND(`CY_Nov_Cumulative_GP`*100,2),ROUND(`CY_Dec_Cumulative_GP`*100,2) FROM padash.table_rev_cost_pa_level order by cy_year desc LIMIT 3;");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs1, con, "GPyoy");
			//System.out.println("part2 completed");
			
			//BMO
			Statement stmt3=con.createStatement();  
			ResultSet rs3=stmt3.executeQuery("SELECT cy_year,ROUND(`sum(``CY_Jan_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Feb_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Mar_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Apr_Cumulative_Rev``)`,2),ROUND(`sum(``CY_May_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jun_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jul_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Aug_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Sep_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Oct_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Nov_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Dec_Cumulative_Rev``)`,2) FROM padash.table_rev_cost_account_level al where account_group='BMO' order by cy_year desc LIMIT 3;");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs3, con, "BMORevyoy");
			//System.out.println("part3 completed");
			
			
			Statement stmt4=con.createStatement();  
			ResultSet rs4=stmt3.executeQuery("SELECT CY_Year,ROUND(`CY_Jan_Cumulative_GP`*100,2),ROUND(`CY_Feb_Cumulative_GP`*100,2),ROUND(`CY_Mar_Cumulative_GP`*100,2),ROUND(`CY_Apr_Cumulative_GP`*100,2),ROUND(`CY_May_Cumulative_GP`*100,2),ROUND(`CY_Jun_Cumulative_GP`*100,2),ROUND(`CY_Jul_Cumulative_GP`*100,2),ROUND(`CY_Aug_Cumulative_GP`*100,2),ROUND(`CY_Sep_Cumulative_GP`*100,2),ROUND(`CY_Oct_Cumulative_GP`*100,2),ROUND(`CY_Nov_Cumulative_GP`*100,2),ROUND(`CY_Dec_Cumulative_GP`*100,2) FROM padash.table_rev_cost_account_level al where account_group='BMO' order by cy_year desc LIMIT 3;");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs4, con, "BMOGPyoy");
			//System.out.println("part4 completed");
			
			// Manulife & insurance Bar
			
			Statement stmt5=con.createStatement();  
			ResultSet rs5=stmt3.executeQuery("(SELECT CONCAT(Account_group, '-', CY_Year),ROUND(`sum(``CY_Jan_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Feb_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Mar_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Apr_Cumulative_Rev``)`,2),ROUND(`sum(``CY_May_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jun_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jul_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Aug_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Sep_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Oct_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Nov_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Dec_Cumulative_Rev``)`,2) FROM padash.table_rev_cost_account_level al where account_group in ('MANULIFE') order by cy_year desc LIMIT 2) UNION (SELECT CONCAT(Account_group, '-', CY_Year),ROUND(`sum(``CY_Jan_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Feb_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Mar_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Apr_Cumulative_Rev``)`,2),ROUND(`sum(``CY_May_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jun_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jul_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Aug_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Sep_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Oct_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Nov_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Dec_Cumulative_Rev``)`,2) FROM padash.table_rev_cost_account_level al1 where account_group in ('INSURANCE') order by cy_year desc LIMIT 3);");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs5, con, "Manulifebar");
			//System.out.println("part5 completed");
			
			Statement stmt5a=con.createStatement();  
			ResultSet rs5a=stmt3.executeQuery("(SELECT CONCAT(Account_group, '-', CY_Year),ROUND(`CY_Jan_Cumulative_GP`*100,2),ROUND(`CY_Feb_Cumulative_GP`*100,2),ROUND(`CY_Mar_Cumulative_GP`*100,2),ROUND(`CY_Apr_Cumulative_GP`*100,2),ROUND(`CY_May_Cumulative_GP`*100,2),ROUND(`CY_Jun_Cumulative_GP`*100,2),ROUND(`CY_Jul_Cumulative_GP`*100,2),ROUND(`CY_Aug_Cumulative_GP`*100,2),ROUND(`CY_Sep_Cumulative_GP`*100,2),ROUND(`CY_Oct_Cumulative_GP`*100,2),ROUND(`CY_Nov_Cumulative_GP`*100,2),ROUND(`CY_Dec_Cumulative_GP`*100,2) FROM padash.table_rev_cost_account_level al where account_group in ('MANULIFE') order by cy_year desc LIMIT 2 ) UNION (SELECT CONCAT(Account_group, '-', CY_Year),ROUND(`CY_Jan_Cumulative_GP`*100,2),ROUND(`CY_Feb_Cumulative_GP`*100,2),ROUND(`CY_Mar_Cumulative_GP`*100,2),ROUND(`CY_Apr_Cumulative_GP`*100,2),ROUND(`CY_May_Cumulative_GP`*100,2),ROUND(`CY_Jun_Cumulative_GP`*100,2),ROUND(`CY_Jul_Cumulative_GP`*100,2),ROUND(`CY_Aug_Cumulative_GP`*100,2),ROUND(`CY_Sep_Cumulative_GP`*100,2),ROUND(`CY_Oct_Cumulative_GP`*100,2),ROUND(`CY_Nov_Cumulative_GP`*100,2),ROUND(`CY_Dec_Cumulative_GP`*100,2) FROM padash.table_rev_cost_account_level al where account_group in ('INSURANCE') order by cy_year desc LIMIT 3); ");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs5a, con, "ManulifeGPyoy");
			//System.out.println("part5a completed");
			
			//RBC
			Statement stmt6=con.createStatement();  
			ResultSet rs6=stmt3.executeQuery("SELECT cy_year,ROUND(`sum(``CY_Jan_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Feb_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Mar_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Apr_Cumulative_Rev``)`,2),ROUND(`sum(``CY_May_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jun_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jul_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Aug_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Sep_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Oct_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Nov_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Dec_Cumulative_Rev``)`,2) FROM padash.table_rev_cost_account_level al where account_group='RBC' order by cy_year desc LIMIT 3;");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs6, con, "RBCRevyoy");
			//System.out.println("part6 completed");
			
			
			Statement stmt7=con.createStatement();  
			ResultSet rs7=stmt3.executeQuery("SELECT CY_Year,ROUND(`CY_Jan_Cumulative_GP`*100,2),ROUND(`CY_Feb_Cumulative_GP`*100,2),ROUND(`CY_Mar_Cumulative_GP`*100,2),ROUND(`CY_Apr_Cumulative_GP`*100,2),ROUND(`CY_May_Cumulative_GP`*100,2),ROUND(`CY_Jun_Cumulative_GP`*100,2),ROUND(`CY_Jul_Cumulative_GP`*100,2),ROUND(`CY_Aug_Cumulative_GP`*100,2),ROUND(`CY_Sep_Cumulative_GP`*100,2),ROUND(`CY_Oct_Cumulative_GP`*100,2),ROUND(`CY_Nov_Cumulative_GP`*100,2),ROUND(`CY_Dec_Cumulative_GP`*100,2) FROM padash.table_rev_cost_account_level al where account_group='RBC' order by cy_year desc LIMIT 3;");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs7, con, "RBCGPyoy");
			//System.out.println("part7 completed");
			
			//SCOTIA
			Statement stmt8=con.createStatement();  
			ResultSet rs8=stmt3.executeQuery("SELECT cy_year,ROUND(`sum(``CY_Jan_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Feb_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Mar_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Apr_Cumulative_Rev``)`,2),ROUND(`sum(``CY_May_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jun_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jul_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Aug_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Sep_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Oct_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Nov_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Dec_Cumulative_Rev``)`,2) FROM padash.table_rev_cost_account_level al where account_group='SCOTIA' order by cy_year desc LIMIT 3;");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs8, con, "SCOTIARevyoy");
			//System.out.println("part8 completed");
			
			
			Statement stmt9=con.createStatement();  
			ResultSet rs9=stmt3.executeQuery("SELECT CY_Year,ROUND(`CY_Jan_Cumulative_GP`*100,2),ROUND(`CY_Feb_Cumulative_GP`*100,2),ROUND(`CY_Mar_Cumulative_GP`*100,2),ROUND(`CY_Apr_Cumulative_GP`*100,2),ROUND(`CY_May_Cumulative_GP`*100,2),ROUND(`CY_Jun_Cumulative_GP`*100,2),ROUND(`CY_Jul_Cumulative_GP`*100,2),ROUND(`CY_Aug_Cumulative_GP`*100,2),ROUND(`CY_Sep_Cumulative_GP`*100,2),ROUND(`CY_Oct_Cumulative_GP`*100,2),ROUND(`CY_Nov_Cumulative_GP`*100,2),ROUND(`CY_Dec_Cumulative_GP`*100,2) FROM padash.table_rev_cost_account_level al where account_group='SCOTIA' order by cy_year desc LIMIT 3;");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs9, con, "SCOTIAGPyoy");
			//System.out.println("part9 completed");
			
			Statement stmt10=con.createStatement();  
			ResultSet rs10=stmt3.executeQuery("(SELECT CONCAT(Account_group, '-', CY_Year),ROUND(`sum(``CY_Jan_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Feb_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Mar_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Apr_Cumulative_Rev``)`,2),ROUND(`sum(``CY_May_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jun_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jul_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Aug_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Sep_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Oct_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Nov_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Dec_Cumulative_Rev``)`,2) FROM padash.table_rev_cost_account_level al where account_group in ('CIBC') order by cy_year desc LIMIT 2) UNION (SELECT CONCAT(Account_group, '-', CY_Year),ROUND(`sum(``CY_Jan_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Feb_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Mar_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Apr_Cumulative_Rev``)`,2),ROUND(`sum(``CY_May_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jun_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Jul_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Aug_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Sep_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Oct_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Nov_Cumulative_Rev``)`,2),ROUND(`sum(``CY_Dec_Cumulative_Rev``)`,2) FROM padash.table_rev_cost_account_level al1 where account_group in ('INTRIA') order by cy_year desc LIMIT 3);");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs10, con, "CIBCRevYoY");
			//System.out.println("part10 completed");
			
			Statement stmt11=con.createStatement();  
			ResultSet rs11=stmt3.executeQuery("(SELECT CONCAT(Account_group, '-', CY_Year),ROUND(`CY_Jan_Cumulative_GP`*100,2),ROUND(`CY_Feb_Cumulative_GP`*100,2),ROUND(`CY_Mar_Cumulative_GP`*100,2),ROUND(`CY_Apr_Cumulative_GP`*100,2),ROUND(`CY_May_Cumulative_GP`*100,2),ROUND(`CY_Jun_Cumulative_GP`*100,2),ROUND(`CY_Jul_Cumulative_GP`*100,2),ROUND(`CY_Aug_Cumulative_GP`*100,2),ROUND(`CY_Sep_Cumulative_GP`*100,2),ROUND(`CY_Oct_Cumulative_GP`*100,2),ROUND(`CY_Nov_Cumulative_GP`*100,2),ROUND(`CY_Dec_Cumulative_GP`*100,2) FROM padash.table_rev_cost_account_level al where account_group in ('CIBC') order by cy_year desc LIMIT 2 ) UNION (SELECT CONCAT(Account_group, '-', CY_Year),ROUND(`CY_Jan_Cumulative_GP`*100,2),ROUND(`CY_Feb_Cumulative_GP`*100,2),ROUND(`CY_Mar_Cumulative_GP`*100,2),ROUND(`CY_Apr_Cumulative_GP`*100,2),ROUND(`CY_May_Cumulative_GP`*100,2),ROUND(`CY_Jun_Cumulative_GP`*100,2),ROUND(`CY_Jul_Cumulative_GP`*100,2),ROUND(`CY_Aug_Cumulative_GP`*100,2),ROUND(`CY_Sep_Cumulative_GP`*100,2),ROUND(`CY_Oct_Cumulative_GP`*100,2),ROUND(`CY_Nov_Cumulative_GP`*100,2),ROUND(`CY_Dec_Cumulative_GP`*100,2) FROM padash.table_rev_cost_account_level al where account_group in ('INTRIA') order by cy_year desc LIMIT 3);");  
			//RevenueYoYPA r2 = new RevenueYoYPA();
			//r2.fillsheet1(rs1,con,"PAdatayoy");
			r.fillSheet1(rs11, con, "CIBCGPyoy");
			//System.out.println("part11 completed");
			
			
			System.out.println("*****************DATA LOADED*****************");
			log.info(" log finished");
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
			
			response.sendRedirect("RevNGp.html");
		
		
			
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
