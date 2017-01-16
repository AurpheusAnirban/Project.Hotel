package utils;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;



public class RetryAnalyzer implements IRetryAnalyzer {

	int minretryCount = 0;
	int maxretryCount = 9;

	public boolean retry(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()){
			Attachments.createAttachment();
		}else if(ITestResult.SKIP == result.getStatus()){
			Attachments.createAttachment();
		}
		if (minretryCount <= maxretryCount)
			
//		We will use "@Test(retryAnalyzer = RetryAnalyzer.class)" on test to retry the test.

		{
			System.out.println("Following test is failing====" + result.getName());
			System.out.println("Retrying the test Count is=== " + (minretryCount + 1));

			minretryCount++;

			return true;
		}
		return false;
	}
}
