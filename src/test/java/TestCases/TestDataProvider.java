package TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "data 1", "data 1", "data 111" }, { "data 2", "data 2", "data 222" } };
	}

	@Test(dataProvider = "data-provider")
	public void testMethod(String data1, String data2, String data3) {
		System.out.println("Data is: " + data1 + data2 + data3);
	}

	@Test
	public void testMethod() {
		System.out.println("Hello");
	}
	@DataProvider(name="rajat")
	public Object[][] Method()
	{
		return new Object[][] {{"data1","data2","data3"},{"data2","data34","data234"}};
		
	}

}