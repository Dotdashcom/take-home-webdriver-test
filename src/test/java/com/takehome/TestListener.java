package com.takehome;

import com.takehome.report.AllureManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        // empty
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // empty
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failTest(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.error(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // empty
    }

    @Override
    public void onStart(ITestContext context) {
        // empty
    }

    @Override
    public void onFinish(ITestContext context) {
        // empty
    }

    private void failTest(ITestResult iTestResult) {
        logger.error(iTestResult.getTestClass().getName());
        logger.error(iTestResult.getThrowable());

        AllureManager.takeScreenshotToAttachOnAllureReport();
    }
}
