package com.QA.BaseUtils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer {

	/**
	 * method that clears and sends keys/text
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	/**
	 * 
	 * @param element
	 * @return object of Select class
	 */
	public static Select getSelectObject (WebElement element) {
		waitForClickability(element);
		Select select = new Select(element);
		return  select;
	}

	/**
	 * method that checks if text is in the drop down and then selects it by text
	 * 
	 * @param element
	 * @param textToSelect
	 */
	public static void selectDdValue(WebElement element, String textToSelect) {
		
		List<WebElement> options = getSelectObject(element).getOptions();

		for (WebElement el : options) {
			if (el.getText().toLowerCase().contains(textToSelect.toLowerCase())) {

				el.click();
				break;

			}
		}
	}

	/**
	 * method checks if radio/checkbox is enabled and clicks it
	 * 
	 * @param radioOrcheckbox
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement> radioOrcheckbox, String value) {

		// for different radio buttons could be different methods recognizing text of
		// value
		for (WebElement el : radioOrcheckbox) {
//			System.out.println(el.getAttribute("value"));
			if (el.isEnabled() && el.getAttribute("value").toLowerCase().contains(value.toLowerCase())) {
				el.click();
				break;
			}
		}
	}

	/**
	 * method that accept alerts and catches exception if alert is not present
	 */
	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method that dismiss alerts and catches exception if alert is not present
	 */
	public static void dismissAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method that gets text of alert and catches exception if alert is not present
	 * 
	 * @return String alert text
	 */
	public static String getAlertText() {

		String alertText = null;

		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}
	
	/**
	 * method that sends text to alert
	 * 
	 * @return String text
	 */
	public static void sendTextToAlert(String string) {

		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(string);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * method will wait when alert present and then accept it
	 */
	public void acceptIfAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			acceptAlert();
		} catch (Exception e) {
			// exception handling
		}
	}

	/**
	 * method that check if alert present and return true or false
	 */
	public boolean isAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**	 
	 * @return object of FluentWait
	 */
	public static Wait<WebDriver> getWaitObjectFluent() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
		return wait;
	}
	
	/**
	 * 
	 * @param element of iframe
	 * @return wait for iframe to be available and then switch to it
	 */
	public static WebDriver switchToFrame(WebElement element) {
		return getWaitObjectFluent().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public static WebDriverWait getWaitObjectExplicit() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {
		return getWaitObjectExplicit().until(ExpectedConditions.elementToBeClickable(element));

	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObjectExplicit().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 
	 * @param maxWaitMillis pass in the maximum wait time in milliseconds
	 * @param pollSeconds   the time between page polls in seconds
	 */
	public void waitForJavascript(int maxWaitMillis, double pollSeconds) {
		double startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() < startTime + maxWaitMillis) {
			String prevState = driver.getPageSource();
			wait(pollSeconds);
			if (prevState.equals(driver.getPageSource())) {
				return;
			}
		}
	}

	/**
	 * method wait for element to be visible and clickable then click on it
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForVisibility(element);
		waitForClickability(element);
		element.click();
	}

	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * another method for click on element thru java script
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	/**
	 * scroll down with java script a number of pixels scroll down
	 * 
	 * @param pixels
	 */
	public static void jsScrollDown(int pixels) {
		getJSObject().executeScript("window.scrollBy(0," + pixels + ")", "");
	}
	
	/**
	 * scroll down to the bottom of page with java script	
	 */
	public static void jsScrollDownToBottom() {
		getJSObject().executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	/**
	 * scroll down with java script a number of pixels scroll up
	 * 
	 * @param pixels
	 */
	public static void jsScrollUp(int pixels) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixels + ")", "");
	}

	/**
	 * scroll to Element with java script
	 *
	 * @param Element
	 */
	public static void jsScrollToElement(WebElement Element) {
		getJSObject().executeScript("arguments[0].scrollIntoView();", Element);
	}

	/**
	 * This Method will take a screenshot and convert it to bytes for attaching to
	 * report
	 * 
	 * @param filename
	 */
	public static byte[] takeScreenshot(String filename) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + " " + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}

	/**
	 * This Method will take a screenshot with Robot class and convert it to bytes
	 * for attaching to report
	 * 
	 * @param filename
	 */
	public static byte[] takeScreenshotRobot(String filename) {

		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + " " + getTimeStamp() + ".png";

		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage Image = r.createScreenCapture(capture);
		ByteArrayOutputStream b = new ByteArrayOutputStream();

		byte[] myscreenshot = b.toByteArray();

		try {
			FileUtils.writeByteArrayToFile(new File(destinationFile), myscreenshot);
			ImageIO.write(Image, "jpg", new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return myscreenshot;
	}

	/**
	 * this method will return time stamp in the format "MM_dd_yyyy_HH_mm_ss"
	 * (11_01_2021_19_40_32) in current(system) TimeZone
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		return sdf.format(date.getTime());
	}

	/**
	 * this method will return time stamp in the format "EEE, dd MMM yyyy HH:mm:ss"
	 * (Thu, 04 Nov 2021 16:48:54) and in GMT TimeZone *****
	 * 
	 * @return
	 */
	public static String getTimeStamp2() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(date.getTime());
	}

	/**
	 * this method will pause executing for number of seconds
	 * 
	 * @param second
	 */
	public static void wait(double second) {
		try {
			Thread.sleep((long) (second * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method will return an object of File class
	 */
	public static File getFileObject(String string) {

		File file = new File(Constants.DOWNLOAD_DIR+string);	

		return file;
	}

	/**
	 * this method will return value of object File[]
	 */
	public static File[] filesDownload() {

		File dir = new File(Constants.DOWNLOAD_DIR);

		if (!dir.exists()) {
			dir.mkdir();
		}

		File[] files = dir.listFiles();

		return files;
	}

	/**
	 * this method will return object of class Actions
	 */
	public static Actions getActionsObj() {
		Actions a = new Actions(driver);
		return a;
	}

	/**
	 * 
	 * @param mainWindow is the name of the main window
	 */
	public static void switchTo2ndWindow(String mainWindow) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String childWindow = it.next();
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
	}

}
