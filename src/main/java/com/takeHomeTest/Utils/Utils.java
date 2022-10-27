package com.takeHomeTest.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.takeHomeTest.base.TestBase;

public class Utils extends TestBase {
	public static final int PAGE_LOAD_WAIT = 30;
	public static final int IMPLICIT_WAIT = 10;

	public static void takeFailedTestScreenShot(String testCaseName) {
		// Get the current date and Time
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		// Save the screen shot in a file
		File screenShotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot
		try {
			FileUtils.copyFile(screenShotFile,
//					new File("./FailedScreenShot\\" + "_" + testCaseName + "_" + timeStamp + ".jpeg"));
			new File("C:\\Users\\skpos\\git\\30th-April-Selenium-Framework\\FailedScreenShot" + "_" + testCaseName + "_" + timeStamp + ".jpeg"));

		} catch (IOException e) {
			System.out.println("Unable to save or take screen shot of failed test " + testCaseName);

		}

	}

	// random email generator 
	public static String generateRandomEmail() {
		String email = RandomStringUtils.randomNumeric(3);
		String emailID = "Salinder" + email + "@gmail.com";
		return emailID;
	}

	// random string/password generator 
	public static String generateRandomPassword() {
		String randomStringForPassword = RandomStringUtils.randomNumeric(3);
		String password = "Manager@" + randomStringForPassword;
		return password;
	}

	// custom sleep method
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

		}
	}

}
