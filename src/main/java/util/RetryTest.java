package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{

	int count =0;
	int retryCount = 1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while (count<retryCount) {
			count ++;
			return true;
		}
		return false;
	}

}
