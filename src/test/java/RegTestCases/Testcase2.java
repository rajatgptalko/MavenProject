package RegTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase2 {
	@Test
	public void validatetitlle()
	{
		String xectedted_title="gmail.com";
		String actual_title="yahoo.com";
		/*if(xectedted_title.equals(actual_title))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}*/
		Assert.assertEquals(xectedted_title, actual_title);
	}

}
