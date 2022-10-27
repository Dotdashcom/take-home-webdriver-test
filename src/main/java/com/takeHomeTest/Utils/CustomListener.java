package com.takeHomeTest.Utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.takeHomeTest.base.TestBase;


public class CustomListener extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test execution has started ..." + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test has pass successfully ..." + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test has failed and taking screenshot ..." + result.getMethod().getMethodName());
		Utils.takeFailedTestScreenShot(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test execution has skipped ..." + result.getMethod().getMethodName());
	}

}
