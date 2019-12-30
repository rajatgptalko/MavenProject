package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String dbUrl = "jdbc:mysql://10.150.200.203:3310/property";					

		//Database Username		
		String username = "apptesting_user";	
        
		//Database Password		
		String password = "App123Test@r321";				

		//Query to Execute		
		String query = "SELECT NEW_URL,SOLR_COUNT_CURRENT FROM seo_urls_data_dump";
 	    //Load mysql jdbc driver		
   	    Class.forName("com.mysql.jdbc.Driver");			
   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();	
	   ResultSet rs= stmt.executeQuery(query);//rs store all rows
	   
	   List<String> l = getUrl(rs);
	   System.out.println(l);
		con.close();
	}
	
	public static List<String> getUrl(ResultSet rs) throws SQLException{
		// While Loop to iterate through all data and print results	
	   List<String> l=new ArrayList<String>();
		while (rs.next()){//row loop
	    	//String TITLE = rs.getString(2);///which type(ist column)						        
            String URL = rs.getString(1);//	(2nd column)
            l.add(URL);
		}
	    return l;
	}
}
