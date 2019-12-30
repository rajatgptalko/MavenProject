package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCase4TryCatchListeners {
	@Test
	public void validatetitlle()
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
		
		
	}
	}




