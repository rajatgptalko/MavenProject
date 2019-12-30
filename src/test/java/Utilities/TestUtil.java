package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.TestBase;

public class TestUtil extends TestBase{
	public static String Filename ;

	//public static String Filename;
	public static void CaptureScreenshot() throws IOException {
		
		Date d=new Date();
		  String Filename=d.toString().replace(":", "_").replace(" ","_")+".jpg";
		File screenshotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,  new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html"+Filename));
	
	}
}

