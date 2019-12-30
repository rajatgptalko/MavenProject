package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//
import Utilities.Constant;
import Utilities.ExcelReader;

public class TestExcelReader {
	WebDriver driver;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\rajattest.xlsx");// pass workbook path

	@BeforeTest
	public void setup() {
		String path ="D:\\jars\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		 driver = new ChromeDriver();
		 driver.get(Constant.geturl);
		System.out.println(driver);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@DataProvider(name="data")
	public Object[][] getData() {
		String sheetName = "LoginTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][cols];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;

	}

	@Test(dataProvider = "data")
	public void doLogin(String username, String password) {
		//System.out.println(username + "----" + password);
		System.out.println(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='emailOrMobile']")).sendKeys(username);
		driver.findElement(By.xpath("//button[@id='btnStep1']")).click();
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
	}
}
