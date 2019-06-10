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
public class FetchSigning extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	// before we open the file check to see if it already exists
	
	
	public static final String COMMA_DELIMITER = ",";
	public static final String next_line = "\n";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchSigning() {
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
			
			Statement stmt1=con.createStatement();  
			ResultSet rs=stmt1.executeQuery("SELECT CY_YEAR,ROUND(`sum(CY_Jan_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Feb_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Mar_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Apr_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_May_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jun_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jul_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Aug_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Sep_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Oct_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Nov_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Dec_Cumulative_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_pa_level order by cy_year desc LIMIT 3;");  
			CreateCSV r = new CreateCSV();
			r.fillSheet1(rs,con,"Signyoy");
			
			Statement stmt2=con.createStatement();  
			ResultSet rs2=stmt2.executeQuery("SELECT  CY_YEAR, ROUND(`sum(CY_Q1_Signing_Local_MN_Amount)`,2),  ROUND(`sum(CY_Q2_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q3_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q4_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_pa_level order by cy_year desc LIMIT 3;");  
			CreateCSV r1 = new CreateCSV();
			r1.fillSheet2(rs2,con,"SignQuar");
			
			
			
			Statement stmt3=con.createStatement();  
			ResultSet rs3=stmt3.executeQuery("SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Jan_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Feb_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Mar_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Apr_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_May_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jun_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jul_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Aug_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Sep_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Oct_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Nov_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Dec_Cumulative_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group='BMO' order by cy_year desc LIMIT 3;");  
			CreateCSV r3 = new CreateCSV();
			r3.fillSheet1(rs3,con,"BMOsignyoy");
			
			System.out.println("executed");
			
			Statement stmt4=con.createStatement();  
			ResultSet rs4=stmt4.executeQuery("SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Q1_Signing_Local_MN_Amount)`,2),  ROUND(`sum(CY_Q2_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q3_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q4_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group='BMO'  order by cy_year desc LIMIT 3;");  
			CreateCSV r4 = new CreateCSV();
			r4.fillSheet2(rs4,con,"BMOsignQuar");
			
			
			
			Statement stmt5=con.createStatement();  
			ResultSet rs5=stmt5.executeQuery("SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Jan_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Feb_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Mar_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Apr_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_May_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jun_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jul_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Aug_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Sep_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Oct_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Nov_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Dec_Cumulative_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group='RBC' order by cy_year desc LIMIT 3;");  
			CreateCSV r5 = new CreateCSV();
			r5.fillSheet1(rs5,con,"RBCsignyoy");
			
			System.out.println("executed");
			
			Statement stmt6=con.createStatement();  
			ResultSet rs6=stmt6.executeQuery("SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Q1_Signing_Local_MN_Amount)`,2),  ROUND(`sum(CY_Q2_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q3_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q4_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group='RBC'order by cy_year desc LIMIT 3;");  
			CreateCSV r6 = new CreateCSV();
			r6.fillSheet2(rs6,con,"RBCsignQuar");
			
			
			Statement stmt7=con.createStatement();  
			ResultSet rs7=stmt7.executeQuery("(SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Jan_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Feb_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Mar_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Apr_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_May_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jun_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jul_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Aug_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Sep_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Oct_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Nov_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Dec_Cumulative_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group in ('CIBC') order by cy_year desc LIMIT 2 ) UNION (SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Jan_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Feb_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Mar_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Apr_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_May_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jun_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jul_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Aug_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Sep_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Oct_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Nov_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Dec_Cumulative_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group in ('INTRIA') order by cy_year desc LIMIT 3) ;");  
			CreateCSV r7 = new CreateCSV();
			r7.fillSheet1(rs7,con,"CIBCsignyoy");
			
			System.out.println("executed");
			
			Statement stmt8=con.createStatement();  
			ResultSet rs8=stmt8.executeQuery("(SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Q1_Signing_Local_MN_Amount)`,2),  ROUND(`sum(CY_Q2_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q3_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q4_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group in ('CIBC') order by cy_year desc LIMIT 2 ) UNION (SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Q1_Signing_Local_MN_Amount)`,2),  ROUND(`sum(CY_Q2_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q2_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q4_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group in ('INTRIA') order by cy_year desc LIMIT 3);");  
			CreateCSV r8 = new CreateCSV();
			r8.fillSheet2(rs8,con,"CIBCsignQuar");
			
			
			Statement stmt10=con.createStatement();  
			ResultSet rs10=stmt10.executeQuery("(SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Jan_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Feb_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Mar_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Apr_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_May_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jun_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jul_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Aug_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Sep_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Oct_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Nov_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Dec_Cumulative_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group in ('MANULIFE') order by cy_year desc LIMIT 2 ) UNION (SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Jan_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Feb_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Mar_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Apr_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_May_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jun_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jul_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Aug_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Sep_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Oct_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Nov_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Dec_Cumulative_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group in ('INSURANCE') order by cy_year desc LIMIT 3) ;");  
			CreateCSV r10 = new CreateCSV();
			r10.fillSheet1(rs10,con,"MANULIFEsignyoy");
			
			System.out.println("executed");
			
			Statement stmt11=con.createStatement();  
			ResultSet rs11=stmt11.executeQuery("(SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Q1_Signing_Local_MN_Amount)`,2),  ROUND(`sum(CY_Q2_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q3_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q4_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group in ('MANULIFE') order by cy_year desc LIMIT 2 ) UNION (SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Q1_Signing_Local_MN_Amount)`,2),  ROUND(`sum(CY_Q2_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q2_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q4_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group in ('INSURANCE') order by cy_year desc LIMIT 3);");  
			CreateCSV r11 = new CreateCSV();
			r11.fillSheet2(rs11,con,"MANULIFEsignQuar");
			
			
			Statement stmt12=con.createStatement();  
			ResultSet rs12=stmt12.executeQuery("SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Jan_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Feb_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Mar_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Apr_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_May_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jun_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Jul_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Aug_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Sep_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Oct_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Nov_Cumulative_Signing_Local_MN_Amount)`,2),ROUND(`sum(CY_Dec_Cumulative_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group='SCOTIA' order by cy_year desc LIMIT 3;");  
			CreateCSV r12 = new CreateCSV();
			r12.fillSheet1(rs12,con,"SCOTIAsignyoy");
			
			System.out.println("executed");
			
			Statement stmt13=con.createStatement();  
			ResultSet rs13=stmt13.executeQuery("SELECT CONCAT(Account_Group,'-',cy_year),ROUND(`sum(CY_Q1_Signing_Local_MN_Amount)`,2),  ROUND(`sum(CY_Q2_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q3_Signing_Local_MN_Amount)`,2),   ROUND(`sum(CY_Q4_Signing_Local_MN_Amount)`,2) FROM padash.table_signing_account_level where Account_Group='SCOTIA' order by cy_year desc LIMIT 3;");  
			CreateCSV r13 = new CreateCSV();
			r13.fillSheet2(rs13,con,"SCOTIAsignQuar");
			
			
			
			System.out.println("*****************DATA LOADED1*****************");
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
			
			response.sendRedirect("Sign.html");
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
