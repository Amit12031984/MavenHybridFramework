package com.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListerner implements IRetryAnalyzer {

	int maxCount = 3;
	int count =1;
	
	public boolean retry(ITestResult result) {
		
		if(count < maxCount) 
		{
			count++;
			return true;
		}
		return false;
	}

}
