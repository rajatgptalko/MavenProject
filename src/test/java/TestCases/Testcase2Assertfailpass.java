package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcase2Assertfailpass {
	@Test
	public void validatetitlle()
	{
		try
		
		{
		/*Reporter.log("Capture screen shot ");//
*/		String xectedted_title="gmail.com";
		String actual_title="yahoo.com";
		/*if(xectedted_title.equals(actual_title))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}*/
		Assert.assertEquals(xectedted_title, actual_title);//it throws error not exception
		}catch(Throwable e)//NOT catch(Exception e)//error or throwable because throwable is super class of error
		{
		System.out.println("Test case failed");
		Reporter.log("Capture screen shot ");
		//Assert.fail();//now AssertionError is null
		Assert.fail(e.getMessage());//for Assertion Error message 
	}
	}

}
