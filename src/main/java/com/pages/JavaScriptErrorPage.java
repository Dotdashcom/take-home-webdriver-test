package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Base;

public class JavaScriptErrorPage extends Base{
	public JavaScriptErrorPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public static void captureJavaScript(WebDriver driver) {
		LogEntries jsErrors=driver.manage().logs().get(LogType.BROWSER);
		System.out.println("Printing all the logs " +jsErrors.getAll());
		System.out.println("Print index 1 Log "+jsErrors.getAll().get(1));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(jsErrors.getAll().get(1).toString().contains("Cannot read properties of undefined (reading 'xyz')"));
	}

}
