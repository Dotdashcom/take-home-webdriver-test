package com.qa.take_home_webdriver_test.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("=====> " + result.getName() + " is started <===== ");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("=====> " + result.getName() + " is successful <===== ");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("=====> " + result.getName() + " has failed <===== ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("=====> " + result.getName() + " has skipped <===== ");
    }


    @Override
    public void onStart(ITestContext context) {
        System.out.println("=====> " + context.getName() + " has started <===== ");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
