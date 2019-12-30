package Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Utilities.TestUtil;		

public class CustomerListeners implements ITestListener						
{		

    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestFailure(ITestResult arg0) {
    	try {
			TestUtil.CaptureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.setProperty("org.uncommons.reportng.escape-output","false");//screen shot ka link dene ke liye (link provided in report
        Reporter.log("test shot");
        Reporter.log("<a href="+TestUtil.Filename+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<a href="+TestUtil.Filename+"><img target=\"_blank\" src="+TestUtil.Filename+" height=200 width=400</img></a>");//ancor tag of image 
        		
    }		

    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		
}		