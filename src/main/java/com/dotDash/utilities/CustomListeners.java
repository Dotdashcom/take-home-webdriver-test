package com.dotDash.utilities;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners extends TestUtil implements ITestListener{

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
		try {
			takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
