package TestCases_base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;

public class Addcumtomer extends TestBase {
	@Test(priority = 1)
	public void LoginAsBankManager() {
		click("BMLBtn_xpath");
		click("addcustomer_xpath");
		inputfields("first_name_xpath", "First_name");
		inputfields("Last_name_xpath", "Last_name");
		inputfields("Postal_code_xpath", "Postal_code");
		wait(40);
		/*click("Add_customer_xpath");
		wait(40);
		getExcelData();*/
		Assert.assertEquals(Alertsgettext(), "Customer added successfully with customer id :6");

		// Assert.assertTrue(isElementPresent("addcustomer_xpath"), "element not
		// found");

	

	/*@Test(priority = 2)
	public void OpenAccount() {
		
		//DoubleClick("Home_xpath");
		DoubleClick("Open_Account_xpath");
		dropdown("Customer_Dropdown", config.getProperty("First_name") + " " + config.getProperty("Last_name"));
		dropdown("currency_drpdown", config.getProperty("currency"));
		click("Process_xpath");
		Assert.assertEquals(Alertsgettext(), "Account created successfully with account Number :1016");*/
	
	/*@Test(dataProvider="getExcelData")
	public void loginfromexcel(String name,String lastname,String postcode)
	
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		click("BMLBtn_xpath");
		click("addcustomer_xpath");
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys(postcode);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}*/
	}
}



