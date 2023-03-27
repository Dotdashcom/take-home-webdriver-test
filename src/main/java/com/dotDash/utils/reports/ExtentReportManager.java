package com.dotDash.utils.reports;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.dotDash.base.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * The Class handles the report activities.
 *
 * @author Seb Geb
 */
public class ExtentReportManager {

	/** The extent reports. */
	private static ExtentReports extentReports;

	/** The map. */
	private static Map<Long, ExtentTest> map = new HashMap<>();

	/**
	 * Gets the extent reports.
	 * 
	 * @author Seb Geb
	 * @return the extent reports
	 */
	public static ExtentReports getExtentReports() {
		if (extentReports == null) {
			extentReports = new ExtentReports(Constants.REPORT_DIRECTORY);
			extentReports.assignProject(Constants.PROJECT_NAME);
			extentReports.loadConfig(new File(Constants.EXTENT_CONFIG_PATH));
		}
		return extentReports;
	}

	/**
	 * Start test.
	 * 
	 * @author Seb Geb
	 * @param testName the test name
	 * @param desc     the desc
	 */
	public synchronized static void startTest(String testName, String desc) {
		ExtentTest test = getExtentReports().startTest(testName, desc);
		map.put(Thread.currentThread().getId(), test);
	}

	/**
	 * Gets the current test.
	 * 
	 * @author Seb Geb
	 * @return the current test
	 */
	public synchronized static ExtentTest getCurrentTest() {
		return map.get(Thread.currentThread().getId());
	}

	/**
	 * End current test.
	 * 
	 * @author Seb Geb
	 */
	public synchronized static void endCurrentTest() {
		getExtentReports().endTest(getCurrentTest());
	}
}
