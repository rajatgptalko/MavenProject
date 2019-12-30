package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBDynamicConeection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		printUrl();
	}

	public static List<String> printUrl() throws ClassNotFoundException, SQLException {
		Connection con = createConnection();

		// Query to Execute
		String query = "SELECT * FROM tpcity_popular_project  LIMIT 10";

		// Create Statement Object
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(query);

		List<String> l = getUrl(rs);
		//System.out.println(l);
		return l;
		// System.out.println(l);
		// con.close();
	}

	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		String dbUrl = "jdbc:mysql://10.150.200.203:3310/property";

		// Database Username
		String username = "apptesting_user";

		// Database Password
		String password = "App123Test@r321";

		// Load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		return con;
	}

	public static List<String> getUrl(ResultSet rs) throws SQLException {
		// While Loop to iterate through all data and print results
		List<String> l = new ArrayList<String>();
		while (rs.next()) {// row loop
			// String TITLE = rs.getString(2);///which type(ist column)
			String URL = rs.getString(3);// (2nd column)
			l.add(URL);
		}
		return l;
	}
	public static String[] convert(List<?> l)
	{
		String[] arr = new String[l.size()]; 
		
		  
        // ArrayList to Array Conversion 
        for (int i =0; i < l.size(); i++) 
        {
            arr[i] = (String) l.get(i); 
        arr[i]=arr[i].replace("/", "https://www.magicbricks.com/");
       // System.out.println(arr[i]);
        }
		return arr;
	}
}
