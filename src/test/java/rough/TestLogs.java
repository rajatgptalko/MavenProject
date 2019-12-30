package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogs {
	/*
	 * to generate logs following things-: .logs files api-log4j(dependency)
	 */
	/*
	 * call class logger log4j.properties/xml-appenders
	 */
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Properties or;
	public static Properties config;

	public static void click(String locator) {
		log.debug("click");
		driver.findElement(By.xpath(or.getProperty(locator))).click();
		log.debug("clicking on elemnt" + locator);
	}

	public static void type(String locator, String value) {
		driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(config.getProperty(value));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		if (driver == null) {
			log.debug("property file loaded");
			or = new Properties();
			config = new Properties();
			FileInputStream f = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.Properties");
			or.load(f);
			log.debug("config file loaded");

			FileInputStream t = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.Properties");
			config.load(t);
			if (config.getProperty("browser").equals("firefox")) {
				log.debug("fireofx launch");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", config.getProperty("driverPath"));
				log.debug("chrome launch");
				driver = new ChromeDriver();

			}
			log.debug("selenium");
			driver.get(config.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")),
					TimeUnit.SECONDS);
			click("xpath");
			type("xpath", "text");
			driver.quit();

		}

	}

}
