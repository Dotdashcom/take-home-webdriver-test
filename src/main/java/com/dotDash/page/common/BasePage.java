package com.dotDash.page.common;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import com.dotDash.utils.ReportUtil;
import com.dotDash.utils.TestProperties;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

/**
 * This is Base Page class, which has generic function to interact with Web
 * Elements
 * 
 * @author Seb Geb
 *
 */
public class BasePage {
	protected WebDriver driver;
	protected Wait<WebDriver> wait;

	/**
	 * Instantiates a new base page with fluent wait
	 *
	 * @param driver the driver
	 */
	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(this.driver)
				.withTimeout(Duration.ofSeconds(Integer.parseInt(TestProperties.getProperty("FLUENT_WAIT_TIMEOUT"))))
				.pollingEvery(Duration.ofSeconds(Integer.parseInt(TestProperties.getProperty("FLUENT_WAIT_POLL"))));
	}

	/**
	 * Wait for Element Existance
	 * 
	 * @author Seb Geb
	 * @param we - WebElement
	 */
	protected void waitForElementExistance(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
		ReportUtil.logMessage(LogStatus.PASS,"Element Exists on Page",we.getText());
	}

	protected void waitForElementNonExistance(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		ReportUtil.logMessage(LogStatus.PASS,"Element not Exists on Page",locator.toString());
	}
	protected void waitForElementExistance(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		ReportUtil.logMessage(LogStatus.PASS,"Element Exists on Page",locator.toString());
	}
	/**
	 * Wait for Element Clickable
	 * 
	 * @author Seb Geb
	 * @param we - WebElement
	 */
	private void waitForElementClickable(WebElement we) {
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}

	public void navigateTo(String url) {
		driver.get(url);
	}

	/**
	 * To Set data into input box after clearing the existing values
	 * 
	 * @author Seb Geb
	 * @param weInput
	 * @param sValue
	 */
	public void setData(WebElement weInput, String sValue) {
		waitForElementExistance(weInput);
		weInput.clear();
		weInput.sendKeys(sValue);
		ReportUtil.logMessage(LogStatus.PASS, "Set Data Successfully", "Set "+sValue+" Successfully");
	}

	/**
	 * To click on Element Seb Geb
	 * 
	 * @param weInput
	 */
	public void clickOnElement(WebElement weInput) {
		try {
			waitForElementClickable(weInput);
			String text = weInput.getText();
			weInput.click();
			ReportUtil.logMessage(LogStatus.PASS, "Click Successfully", "Click Successfully :"+ text);
		}catch(ElementClickInterceptedException e) {
			clickOnElementJSE(weInput);
		}
	}
	
	/**
	 * To click on Element Seb Geb
	 * 
	 * @param weInput
	 */
	public void clickOnElementJSE(WebElement weInput) {
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", weInput);
			ReportUtil.logMessage(LogStatus.PASS, "Click on Element using JavascriptExecutor", "Clicked Successfully");
	}
	/**
	 * To check if WebElement exists or not
	 * @param we-WebElement
	 * @return true-if exists else false
	 */
	public boolean checkWebElementExist(WebElement we) {
		boolean bFlag = false;
		try {
			waitForElementExistance(we);
			bFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFlag;
	}

	/**
	 * To get element Attribute
	 * @param we-WebElement
	 *
	 * @return true-if exists else false
	 */
	public String getWebElementAttribute(WebElement we,String attributeName) {
		String attributeValue=null;
		try {
			waitForElementExistance(we);
			attributeValue=we.getAttribute(attributeName);
			ReportUtil.logMessage(LogStatus.PASS, "Attribute value extracted", "Attribute Value Extracted :"+attributeValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attributeValue;
	}

	/**
	 * To Right/Context Click on element
	 * @param we-WebElement
	 *
	 * @return true-if exists else false
	 */
	public String rightClick(WebElement we) {
		String attributeValue=null;
		try {
			Actions actions = new Actions(driver);
			actions.contextClick(we).build().perform();
			ReportUtil.logMessage(LogStatus.PASS, "Right Click successful", "Right Click successful");
		} catch (Exception e) {
			ReportUtil.logMessage(LogStatus.FAIL, "Right Click Faile", e.getMessage());
		}
		return attributeValue;
	}

	/**
	 * To Select data into drop down box after clearing the existing values
	 *
	 * @author Seb Geb
	 * @param weInput
	 * @param sValue
	 */
	public void selectDropDown(WebElement weInput, String sValue) {
		waitForElementExistance(weInput);
		Select select= new Select(weInput);
		select.selectByVisibleText(sValue);
		ReportUtil.logMessage(LogStatus.PASS, "Selected Data Successfully", "Selected "+sValue+" Successfully");
	}
	/**
	 * To Assert Value Equals
	 *
	 * @author Seb Geb
	 * @param actual
	 * @param expected
	 */
	public void assertEquals(String message,Object actual,Object expected) {
		Assert.assertEquals(actual, expected);
		ReportUtil.logMessage(LogStatus.PASS, message, "EXPECTED: "+expected+"\n\nACTUAL:: "+actual);
	}

	/**
	 * To Assert Value Not Equals
	 *
	 * @author Seb Geb
	 * @param actual
	 * @param expected
	 */
	public void assertNotEquals(String message,Object actual,Object expected) {
		Assert.assertNotEquals(actual, expected);
		ReportUtil.logMessage(LogStatus.PASS, message, "EXPECTED: "+expected.toString()+"\n\nACTUAL:: "+actual.toString());
	}

	/**
	 * Waits for File to Download and deletes once downloaded
	 * @param expectedFileName
	 */
	public void waitForFileToDownload(String expectedFileName){
		String filePath = System.getProperty("java.io.tmpdir")+ expectedFileName;
		File file = new File(filePath );
		wait.until((ExpectedCondition<Boolean>) webDriver -> file.exists());
		ReportUtil.logMessage(LogStatus.PASS,"Check for File Existance","File Exists at "+filePath);
		if (file.exists())
			file.delete();
	}
}
