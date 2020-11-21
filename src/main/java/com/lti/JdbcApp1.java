package com.lti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//ctrl+shift+o->auto import
public class JdbcApp1 
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	public JdbcApp1()
	{
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rk","rk");
		st = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	//business logic method
	
	public void getAccountDetails()
	{
		try {
		rs = st.executeQuery("select * from account");
		while(rs.next()) {
			
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
			
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
