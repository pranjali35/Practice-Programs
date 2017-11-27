
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

public class JavaMySql {
	

//	            c =DriverManager.getConnection("jdbc:mysql://sql1.njit.edu:3306/pct9", "pct9", "5VgECuLtv");
	public static void main(String args[]){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://sql1.njit.edu:3306/pct9","pct9", "5VgECuLtv");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from employee");  
		ResultSetMetaData rsmd = rs.getMetaData();
		 int columnsNumber = rsmd.getColumnCount();
		   while (rs.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           if (i > 1) System.out.print(",  ");
		           String columnValue = rs.getString(i);
		           System.out.print(columnValue + " " + rsmd.getColumnName(i));
		       }
		       System.out.println("");
		   } 
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
		}  

	        }
	      
