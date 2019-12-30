package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1Annotations {

	@BeforeTest /// (in this class first this will executed)
	public void dbConnection() {
		System.out.println("set connection");
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

	@Test(retryAnalyzer=Listeners.RetryAnalyser.class)//Retry Logic(for not qright in each test ue transformaer))
	public void doLogin() {
		System.out.println("Executing login test");
	}

	/*@Test(priority = 2)
	public void UserRegistration() {
		System.out.println("new test");
	}*/

	@AfterMethod // after every methos thi will executed
	public void closebrowser() {
		System.out.println("closing the browser");
	}
}
