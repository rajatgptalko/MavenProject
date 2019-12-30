package TestCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Testcase3priorityDependsonmethods {
	@Test(priority = 1, dependsOnMethods = "UserRegistration") // if userregistration fail then thi will skip
	public void doLogin() {
		System.out.println("Executing login test");
	}

	@Test(priority = 2)
	public void UserRegistration() {
		System.out.println("new test");
		Assert.fail("user reg not successfully");/// not registration therefore doLogin fails
	}

	// to force fully skipping the method -:
	@Test(priority = 3)
	public void conposeemial() {
		throw new SkipException("condition not met");// to force fully skip the method

	}

}
