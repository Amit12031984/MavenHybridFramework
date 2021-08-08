package com.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Base.TestBase;

public class TestListners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result)
	{
		log.info("Test case is starting "+ result.getName());
	}
	public void onTestSuccess(ITestResult result)
	{
		log.info("Test case is passed "+ result.getName());
	}
	public void onTestFailure(ITestResult result)
	{
		log.info("Test case failed with name "+ result.getName());
		GetScreenShot(result.getName());
		log.info("Screen shot captured for failed test case");
	}
	public void onTestSkipped(ITestResult result)
	{
		log.info("Test case skipped with name "+ result.getName());
	}
	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}
	public void onStart(ITestContext context)
	{
		log.info("Test suite started");
	}
	public void onFinish(ITestContext context)
	{
		log.info("Test suite finished");
	}
}
