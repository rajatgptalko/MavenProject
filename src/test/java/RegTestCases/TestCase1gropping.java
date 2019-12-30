package RegTestCases;

import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.DBDynamicConeection;

public class TestCase1gropping {

	@BeforeTest /// (in this class first this will executed)
	public void dbConnection() throws ClassNotFoundException, SQLException {
		System.out.println("set connection");
		/*DBDynamicConeection.printUrl();
		List<String> l=	DBDynamicConeection.printUrl();
		String s[]=DBDynamicConeection.convert(l);
		for(int i=0;i<s.length;i++)
		{
		System.out.println(s[i]);
	}*/
	}
	
	@AfterTest /// (in thi class ye sabse last me
				/// )
	public void dbcloseConnection() {
		System.out.println("close connection");
	}

	@BeforeMethod /// before every method this will executed
	public void launchingbrowser() {
		System.out.println("launching browser");
	}

	@Test(priority = 1,groups="regression")
	public void doLogin() {
		System.out.println("Executing login test");
	}

	@Test(priority = 2,groups={"bvt","functional"})//grpups defines we can run testcases in grps(prod pe run )
	public void UserRegistration() {
		System.out.println("new test");
	}

	@AfterMethod // after every methos thi will executed
	public void closebrowser() {
		System.out.println("closing the browser");
	}
}
