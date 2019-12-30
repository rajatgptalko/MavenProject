package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterizationExcel {
	public static WebDriver driver;

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "test@gmail.com";
		data[0][1] = "kjbjhb";

		data[1][0] = "test@gmail.com";
		data[1][1] = "kjbjhbknkjh";
		return data;

	}

	@Test(dataProvider = "getData")
	public void doLogin(String username, String password) {
		System.out.println(username + "----" + password);
		driver.findElement(By.xpath(""));
	}
}
