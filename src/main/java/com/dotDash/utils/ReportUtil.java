package com.dotDash.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.dotDash.base.WebDriverContext;
import com.dotDash.utils.reports.ExtentReportManager;
import com.relevantcodes.extentreports.LogStatus;

/**
 * The Class is responsible for Reporting
 *
 * @author Seb Geb
 */
public class ReportUtil {

	/**
	 * Adds the screen shot.
	 * 
	 * @author Seb Geb
	 * @param message the message
	 */
	public static void addScreenShot(String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message,
				ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image));
	}

	/**
	 * Adds the screen shot.
	 * 
	 * @author Seb Geb
	 * @param status  the status
	 * @param message the message
	 */
	public static void addScreenShot(LogStatus status, String message) {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().log(status, message,
				ExtentReportManager.getCurrentTest().addBase64ScreenShot(base64Image));
	}

	/**
	 * Logs INFO message
	 * 
	 * @author Seb Geb
	 * @param message
	 * @param details
	 */
	public static void logMessage(String message, String details) {
		ExtentReportManager.getCurrentTest().log(LogStatus.INFO, message, details);
	}
	/**
	 * Logs result into Extent report
	 * @author Seb Geb
	 * @param status
	 * @param message
	 * @param details
	 */
	public static void logMessage(LogStatus status, String message, String details) {
		ExtentReportManager.getCurrentTest().log(status, message, details);
	}
}
