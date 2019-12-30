package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import Utilities.DBDynamicConeection;
import Utilities.ExcelReader;
import Utilities.Mailer;

public class TestBase {
	/*
	 * WebDriver logs propeties db mail excel screenshots reports
	 */
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\rajattest.xlsx");
	public static WebDriverWait wait;
	public static Mailer mail = new Mailer();
	public static DBDynamicConeection DBConnection;

	@BeforeSuite // call before suits framework me sabse pehele
	public void setup() throws IOException {
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.Properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.Properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();

			}
			try {
				config.load(fis);
			} catch (IOException e) {
				e.printStackTrace();

			}
			if (config.getProperty("browser").equals("firefox")) {
				log.debug("firefox driver");
				driver = new FirefoxDriver();
				log.debug("firefox launch");
			} else if (config.getProperty("browser").equals("chrome")) {
				log.debug("chrome driver");
				System.setProperty("webdriver.chrome.driver", config.getProperty("driverPath"));
				driver = new ChromeDriver();
				log.debug("chrome launch");
			}
			driver.get(config.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("EmplicitWait")));
			/*
			 * try { DBConnection.printUrl(); } catch (ClassNotFoundException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } catch (SQLException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); }
			 */
		}
	}

	public static void wait(int i) {
		log.debug("wait for agoven time" + i);
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}

	public static void click(String locator) {
		try {
			if (locator.endsWith("_xpath")) {
				driver.findElement(By.xpath(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_css")) {
				driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_id")) {
				driver.findElement(By.id(OR.getProperty(locator))).click();
			}
			log.debug("clicking on an element:  " + locator);

		} catch (Throwable e) {
			log.debug(e.getMessage());
		}
	}

	public static void DoubleClick(String Locator) {
		try {
			Actions action = new Actions(driver);
			if (Locator.endsWith("_xpath")) {
				WebElement menu = driver.findElement(By.xpath(OR.getProperty(Locator)));
				action.doubleClick(menu).perform();
			}
		} catch (Throwable e) {
			log.debug(e.getMessage());
		}

	}

	public static void inputfields(String Locator, String field) {
		try {
			if (Locator.endsWith("_xpath")) {
				driver.findElement(By.xpath(OR.getProperty(Locator))).sendKeys(config.getProperty(field));
			} else if (Locator.endsWith("_css")) {
				driver.findElement(By.cssSelector(OR.getProperty(Locator))).sendKeys(config.getProperty(field));
			}
			log.debug("sending on an element:  " + Locator);

		} catch (Throwable e) {
			log.debug(e.getMessage());
		}
	}

	/*
	 * public static void alertaccepts() { try { Alert alert =
	 * driver.switchTo().alert(); alert.accept();
	 * log.debug("alert accept successfully"); } catch (Throwable e) {
	 * log.debug("alert not present"); log.debug(e.getMessage()); } }
	 */

	public static String Alertsgettext() {
		try {
			Alert alert = driver.switchTo().alert();
			String s = alert.getText();
			alert.accept();

			return s;
		} catch (Throwable e) {
			log.debug(e.getMessage());
			return ("alert not present");
		}
	}

	public static void dropdown(String locator, String name) {
		WebElement dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		Select select = new Select(dropdown);
		List<WebElement> links = driver.findElements(By.tagName("option"));
		for (WebElement l : links) {
			if (l.getText().equals(name)) {
				break; 
			}
		}
		select.selectByVisibleText(name);
	}
	

	public static void SwitchToWindow(String Locator) {
		try {
			Set<String> s = driver.getWindowHandles();
			
			for(String k:s)
			{
			driver.switchTo().window(k);
			if(driver.findElement(By.xpath(OR.getProperty(Locator))).isDisplayed())
			{
				break;
			}
			}
		
		/*	for (int i = 0; i <= s.size(); i++) {
				Iterator<String> t = s.iterator();
				String y = t.next();
				driver.switchTo().window(y);
				if (driver.findElement(By.xpath(OR.getProperty(Locator))).isDisplayed()) {
					break;
				}
			}*/

		} catch (Throwable e) {
			log.debug(e.getMessage());
		}
	}

	public static boolean isElementPresent(String locator) {
		try {
			if (locator.endsWith("_xpath")) {
				driver.findElement(By.xpath(OR.getProperty(locator)));
			} else if (locator.endsWith("_css")) {
				driver.findElement(By.cssSelector(OR.getProperty(locator)));
			} else if (locator.endsWith("_id")) {
				driver.findElement(By.id(OR.getProperty(locator)));
			}
			log.debug("finding element");
			return true;

		} catch (Throwable e) {
			log.debug(e.getMessage());
			return false;
		}
	}

	@DataProvider
	public Object[][] getExcelData() {
		String sheetName = "LoginTest";
		int rows = excel.getRowCount(sheetName);
		int columns = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][columns];
		for (int i = 2; i <= rows; i++) {
			for (int j = 0; j < columns; j++) {
				data[i - 2][j] = excel.getCellData(sheetName, j, i);
			}
		}
		return data;
	}

	@AfterSuite // call framework me sabse baad me
	public void teardown() {
		driver.quit();
		log.debug("close successfully");
	}
}
