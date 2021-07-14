package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.Reporter;

public class JavaScriptsErrorPage extends BasePage {

	WebDriver obj_Driver;

	String jsErrorMsg = "//p";
	String jsErrorText = "Cannot read property 'xyz' of undefined";

	public JavaScriptsErrorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.obj_Driver = driver;
	}

	public void isDisplayedPage() {
		explicitWait(jsErrorMsg);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(jsErrorMsg)).size() > 0, "JS Error page is displayed");
	}

	public void jsError() {
		boolean jsErrorFlag = false;
		for (LogEntry log : getJsError()) {
			if (log.toString().contains(jsErrorText)) {
				jsErrorFlag = true;
				break;
			}
		}
		if (jsErrorFlag) {
			Reporter.log("JS error is displayed");
		} else
			Assert.assertTrue(false, "JS error is not displayed");

	}

}
