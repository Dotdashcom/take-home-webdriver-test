package com.arthi.automation.reporters;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

public class ExtentTestManager {
	private static Map<String, ExtentTest> extentParentTestMap = new HashMap<String, ExtentTest>();
	private static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	private static ExtentReports extent;

	public static synchronized void startReport(final String reportName) {
		extent = ExtentReport.getInstance(reportName);
	}
	
	
	public static synchronized ExtentTest createTest(String className) {
		ExtentTest parent = extent.createTest(className);
		extentParentTestMap.put(className, parent);
		return parent;
	}
	
	public static synchronized ExtentTest getParent(final String className) {
		return (ExtentTest) extentParentTestMap.get(className);		
	}
	
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized ExtentTest startTest(String className, String testName, @Optional String testDescription) {
		ExtentTest test = getParent(className).createNode(testName, testDescription);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
	
	public static synchronized void endTest() {
		extent.flush();
	}

	public static void logPass(String successMessage){
		getTest().log(Status.PASS, successMessage);
	}
	
	public static void logFail(String failureMessage){
		getTest().log(Status.FAIL, failureMessage);
	}
	
	public static void logFailWithScreenShot(String failureMessage, MediaEntityModelProvider mediaProvider){
		getTest().log(Status.FAIL, failureMessage, mediaProvider);
	}
	
	public static void logInfo(String infoMessage){
		getTest().log(Status.INFO, infoMessage);
	}
	
	public static void logError(String errorMessage){
		getTest().log(Status.ERROR, errorMessage);
	}
	
	public static void logError(String errorMessage, Throwable t){
		getTest().log(Status.ERROR, errorMessage);
	}
	
	public static void logWarning(String warnMessage){
		getTest().log(Status.WARNING, warnMessage);
	}
	
	public static void logFatal(String fatalMessage){
		getTest().log(Status.FATAL, fatalMessage);
	}
	
	public static void logSkip(String skipMessage){
		getTest().log(Status.SKIP, skipMessage);
	}
	
	public static void logDebug(String debugMessage){
		getTest().log(Status.DEBUG, debugMessage);
	}	
}