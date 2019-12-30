package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.Constant;
import Utilities.ExcelReader;

public class TestRegistratRxcelReader {
	WebDriver driver;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\rajattest.xlsx");// pass workbook path

	@BeforeTest
	public void setup() {
		String path = "D:\\jars\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(Constant.geturl);
		System.out.println(driver);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		String sheetName = "LoginTest";
		int rows = excel.getRowCount(sheetName);
		int columns = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][columns];
		for (int i = 2; i <= rows; i++)
		{
			for (int j = 0; j < columns; j++) {
				data[i - 2][j] = excel.getCellData(sheetName, j,i);
			}
		}
		return data;
	}
	@Test(dataProvider = "getData")
	public void doLogin(String firstname, String lastname ,String Postalcode) {
		//System.out.println(username + "----" + password);
		System.out.println(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys(Postalcode);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
}



