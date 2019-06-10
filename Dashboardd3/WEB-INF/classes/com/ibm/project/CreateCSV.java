package com.ibm.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;



public class CreateCSV {
	
	public static final String COMMA_DELIMITER = ",";
	public static final String next_line = "\n";
	
	public static final String space = "           ";
	
	//String csvfilepath = "C:\\Dashboard_WS\\Dashboardd3\\WebContent\\";
	
	String csvfilepath ="C:\\apache-tomcat-6.0.32\\webapps\\Dashboardd3\\";
	
	public void fillSheet1(ResultSet rs,Connection con ,String filename) 
	{
		try
		{
		File fl = new File(csvfilepath+filename+".csv");
		File f2 = new File(csvfilepath+filename+"data.csv");
		FileWriter acceptFileWriter = new FileWriter(fl);
        FileWriter datawriter = new FileWriter(f2);
        datawriter.append("Year");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Jan_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Feb_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Mar_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Apr_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("May_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Jun_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Jul_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Aug_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Sep_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Oct_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Nov_C");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Dec_C");
        datawriter.append(next_line);
        
        
		acceptFileWriter.append("year");
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("month");
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("revenue");
		acceptFileWriter.append(next_line);
		while(rs.next())  
		{
			if(rs.getString(1) !=null)
			datawriter.append(rs.getString(1));
			else
			datawriter.append("");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(2) !=null && new Double(rs.getString(2)).doubleValue() != 0 )
				datawriter.append(rs.getString(2));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(3) !=null && new Double(rs.getString(3)).doubleValue() != 0 )
				datawriter.append(rs.getString(3));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(4) !=null && new Double(rs.getString(4)).doubleValue() != 0 )
				datawriter.append(rs.getString(4));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(5) !=null && new Double(rs.getString(5)).doubleValue() != 0 )
				datawriter.append(rs.getString(5));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(6) !=null && new Double(rs.getString(6)).doubleValue() != 0 )
				datawriter.append(rs.getString(6));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(7) !=null && new Double(rs.getString(7)).doubleValue() != 0 )
				datawriter.append(rs.getString(7));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			System.out.println("***"+rs.getString(7));
			System.out.println("&&&"+rs.getString(8));
			
			if(rs.getString(8) !=null && new Double(rs.getString(8)).doubleValue() != 0 )
				datawriter.append(rs.getString(8));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(9) !=null && new Double(rs.getString(9)).doubleValue() != 0 )
				datawriter.append(rs.getString(9));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(10) !=null && new Double(rs.getString(10)).doubleValue() != 0 )
				datawriter.append(rs.getString(10));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(11) !=null && new Double(rs.getString(11)).doubleValue() != 0 )
				datawriter.append(rs.getString(11));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(12) !=null && new Double(rs.getString(12)).doubleValue() != 0 )
				datawriter.append(rs.getString(12));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(13) !=null && new Double(rs.getString(13)).doubleValue() != 0 )
				datawriter.append(rs.getString(13));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
		acceptFileWriter.append(rs.getString(1));
		
		System.out.println("aaaaaaaa");
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("1");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(2) != null && new Double(rs.getString(2)).doubleValue() != 0)
		acceptFileWriter.append(rs.getString(2));
		else
		acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("2");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(3) != null && new Double(rs.getString(3)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(3));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		System.out.println("bbbbbbbbbbbb");
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("3");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(4) != null && new Double(rs.getString(4)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(4));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("4");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(5) != null &&  new Double(rs.getString(5)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(5));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		System.out.println("ccccccccccccccccc");
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("5");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(6) != null && new Double(rs.getString(6)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(6));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("6");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(7) != null && new Double(rs.getString(7)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(7));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		System.out.println("ddddddddddddd");
		
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("7");
		acceptFileWriter.append(COMMA_DELIMITER);
		
		System.out.println("praveen rs.getString(8) "+rs.getString(8));
		if(rs.getString(8) != null && new Double(rs.getString(8)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(8));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("8");
		acceptFileWriter.append(COMMA_DELIMITER);
		System.out.println("praveen rs.getString(9) "+rs.getString(9));
		if(rs.getString(9) != null && new Double(rs.getString(9)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(9));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("9");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(10) != null && new Double(rs.getString(10)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(10));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		System.out.println("hhhhhhhh");
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("10");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(11) != null && new Double(rs.getString(11)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(11));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("11");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(12) != null && new Double(rs.getString(12)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(12));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("12");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(13) != null && new Double(rs.getString(13)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(13));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		datawriter.append(next_line);
		
		System.out.println("3333333333333333333");
		}
		System.out.println("comming here");
		//con.close();  
		acceptFileWriter.flush();
		acceptFileWriter.close();
		
		datawriter.flush();
		datawriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void fillSheet2(ResultSet rs,Connection con ,String filename) 
	{
		try
		{
		File fl = new File(csvfilepath+filename+".csv");
		File f2 = new File(csvfilepath+filename+"data.csv");
		FileWriter acceptFileWriter = new FileWriter(fl);
        FileWriter datawriter = new FileWriter(f2);
        datawriter.append("Year");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Q1_$M CAD");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Q2_$M CAD");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Q3_$M CAD");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append("Q4_$M CAD");
        datawriter.append(COMMA_DELIMITER);
        datawriter.append(next_line);
        
        
		acceptFileWriter.append("year");
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("month");
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("revenue");
		acceptFileWriter.append(next_line);
		while(rs.next())  
		{
			if(rs.getString(1) !=null)
			datawriter.append(rs.getString(1));
			else
			datawriter.append("");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(2) !=null && new Double(rs.getString(2)).doubleValue() != 0 )
				datawriter.append(rs.getString(2));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(3) !=null && new Double(rs.getString(3)).doubleValue() != 0 )
				datawriter.append(rs.getString(3));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(4) !=null && new Double(rs.getString(4)).doubleValue() != 0 )
				datawriter.append(rs.getString(4));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			if(rs.getString(5) !=null && new Double(rs.getString(5)).doubleValue() != 0 )
				datawriter.append(rs.getString(5));
				else
				datawriter.append("0");
			datawriter.append(COMMA_DELIMITER);
			
			
			
		acceptFileWriter.append(rs.getString(1));
		
		System.out.println("aaaaaaaa");
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("1");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(2) != null && new Double(rs.getString(2)).doubleValue() != 0)
		acceptFileWriter.append(rs.getString(2));
		else
		acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("2");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(3) != null && new Double(rs.getString(3)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(3));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		System.out.println("bbbbbbbbbbbb");
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("3");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(4) != null && new Double(rs.getString(4)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(4));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		
		acceptFileWriter.append(rs.getString(1));
		acceptFileWriter.append(COMMA_DELIMITER);
		acceptFileWriter.append("4");
		acceptFileWriter.append(COMMA_DELIMITER);
		if(rs.getString(5) != null &&  new Double(rs.getString(5)).doubleValue() != 0)
			acceptFileWriter.append(rs.getString(5));
			else
			acceptFileWriter.append("null");	
		acceptFileWriter.append(next_line);
		
		
		//acceptFileWriter.append(next_line);
		datawriter.append(next_line);
		
		System.out.println("3333333333333333333");
		}
		System.out.println("comming here");
		//con.close();  
		acceptFileWriter.flush();
		acceptFileWriter.close();
		
		datawriter.flush();
		datawriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void fillSheet3(ResultSet rs,Connection con ,String filename) 
	{
		try
		{
			File fl = new File(csvfilepath+filename+".csv");
			File f2 = new File(csvfilepath+filename+"data.csv");
			FileWriter acceptFileWriter = new FileWriter(fl);
	        FileWriter datawriter = new FileWriter(f2);
	        
	        datawriter.append("Year");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Jan");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Feb");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Mar");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Apr");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("May");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Jun");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Jul");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Aug");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Sep");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Oct");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Nov");
	        datawriter.append(COMMA_DELIMITER);
	        datawriter.append("Dec");
	       
	        
	        
			acceptFileWriter.append("year");
			acceptFileWriter.append(COMMA_DELIMITER);
			acceptFileWriter.append("month");
			acceptFileWriter.append(COMMA_DELIMITER);
			acceptFileWriter.append("revenue");
			acceptFileWriter.append(next_line);
			String year = "";
			while(rs.next())  
			{
				
				acceptFileWriter.append(rs.getString(1));
				acceptFileWriter.append(COMMA_DELIMITER);
				if(! year.equals(rs.getString(1)))
				{
					 datawriter.append(next_line);
					year=rs.getString(1);
				 datawriter.append(rs.getString(1));
				datawriter.append(COMMA_DELIMITER);
				}
				
				acceptFileWriter.append(rs.getString(2));
				acceptFileWriter.append(COMMA_DELIMITER);
				acceptFileWriter.append(rs.getString(3));
				acceptFileWriter.append(COMMA_DELIMITER);
				datawriter.append(rs.getString(3));
				datawriter.append(COMMA_DELIMITER);
				
				acceptFileWriter.append(next_line);
				
			}
			
			acceptFileWriter.flush();
			acceptFileWriter.close();
			datawriter.flush();
			datawriter.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
