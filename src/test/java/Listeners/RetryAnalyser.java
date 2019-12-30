package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int counter = 0;
	int RetryLimit = 3;

	public boolean retry(ITestResult arg0) {
		if (counter < RetryLimit) {
			counter++;
			return true;
		} else

			return false;
	}

}
