package com.theInternetPages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {

	WebDriver obj_Driver;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.obj_Driver = driver;
		this.js = (JavascriptExecutor) obj_Driver;
	}

	public void click(String xPath, String fieldName) {
		try {
			obj_Driver.findElement(By.xpath(xPath)).click();
			Reporter.log("User is able to click on " + fieldName);
		} catch (Exception e) {
			Reporter.log("User is unable to click on " + fieldName + " and error trace is " + e.getStackTrace());
		}
	}

	public void setValue(String xPath, String value, String fieldName) {
		try {
			obj_Driver.findElement(By.xpath(xPath)).clear();
			obj_Driver.findElement(By.xpath(xPath)).sendKeys(value);
			Reporter.log("User is able to enter value in " + fieldName);
		} catch (Exception e) {
			Reporter.log("User is unable to enter value in " + fieldName + " and error trace is " + e.getStackTrace());
		}
	}

	public void isDisplayedAssert(String xPath, String fieldName) {
		try {
			System.out.println("assertion is " + obj_Driver.findElement(By.xpath(xPath)).isDisplayed());
			Assert.assertEquals(obj_Driver.findElement(By.xpath(xPath)).isDisplayed(), true,
					fieldName + " is not displayed");
			Reporter.log(fieldName + " is displayed");
		} catch (Exception e) {
			Reporter.log(fieldName + "is not displayed" + e.getStackTrace());
		}
	}

	public void rightClick(String xpath) {
		Actions obj_Action = new Actions(obj_Driver);

		try {
			obj_Action.contextClick(obj_Driver.findElement(By.xpath(xpath))).build().perform();
			Reporter.log("User is able to right click");
		} catch (Exception e) {
			Reporter.log("User is unable to right click " + e.getStackTrace());
		}

	}

	public void alertAcceptWithVerifyText(String msg) {
		Alert obj_Alert = obj_Driver.switchTo().alert();
		String alertText = obj_Alert.getText();
		Assert.assertTrue(alertText.equalsIgnoreCase(msg), "Alert text is not displayed correctly");
		Reporter.log("Alert text is displayed correctly");
		obj_Alert.accept();

	}

	public void alertAccept() {
		Alert obj_Alert = obj_Driver.switchTo().alert();
		obj_Alert.accept();

	}

	public void setAlertText(String msg) {
		Alert obj_Alert = obj_Driver.switchTo().alert();
		obj_Alert.sendKeys(msg);
	}

	public void dragAndDrop(String xpathFrom, String xpathTo) {
		Actions obj_Action = new Actions(obj_Driver);
		try {
			obj_Action.clickAndHold(obj_Driver.findElement(By.xpath(xpathFrom))).moveToElement(obj_Driver.findElement(By.xpath(xpathTo))).build().perform();
//			obj_Action
//					.dragAndDrop(obj_Driver.findElement(By.xpath(xpathFrom)), obj_Driver.findElement(By.xpath(xpathTo)))
//					.perform();
//				obj_Action.dragAndDrop(obj_Driver.findElement(By.xpath(xpathFrom)), obj_Driver.findElement(By.xpath(xpathTo))).build().perform();

		} catch (Exception e) {
			Reporter.log("Unable to perform Drag and Drop Operation " + e.getStackTrace());
		}
	}

	public void dropDownSelect(String xpathSelect, String optionText) {
		try {
			Select obj_Select = new Select(obj_Driver.findElement(By.xpath(xpathSelect)));
			obj_Select.selectByVisibleText(optionText);
			System.out.println("v " + obj_Select.getFirstSelectedOption().getText());
			if (obj_Select.getFirstSelectedOption().getText().equalsIgnoreCase(optionText)) {
				Reporter.log(optionText + " option is selected correctly");
			} else {
				Reporter.log(optionText + " option is not selected correctly");
				Assert.assertTrue(false, "Option is not selected correctly");
			}
		}

		catch (Exception e) {
			Reporter.log("Unable to select from Drop doowm " + e.getStackTrace());
		}

	}

	public void explicitWait(String xpath) {
		WebDriverWait wait = new WebDriverWait(obj_Driver, 20000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	public void scrollDown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public void mouseHover(String xpath) {
		Actions obj_Action = new Actions(obj_Driver);
		try {
			obj_Action.moveToElement(obj_Driver.findElement(By.xpath(xpath))).perform();
			Reporter.log("User is able to Hover");
		} catch (Exception e) {
			Reporter.log("User is unable to hover " + e.getStackTrace());
		}
	}

	public void jsClick(String xpath) {
		js.executeScript("arguments[0].click();", obj_Driver.findElement(By.xpath(xpath)));

	}

	public List<LogEntry> getJsError() {
		LogEntries logEntries = obj_Driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = logEntries.getAll();
		return logs;
	}
}
