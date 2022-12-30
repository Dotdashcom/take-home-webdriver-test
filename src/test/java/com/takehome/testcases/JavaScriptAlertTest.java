package com.takehome.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.JavascriptAlertsPage;

public class JavaScriptAlertTest {

	DriverScript driverSetup;
	JavascriptAlertsPage page;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
	}
	@Test
	public void javascriptalert() {
		page = new JavascriptAlertsPage(driverSetup.getDriver(), driverSetup.getBaseURL());

		// Test Clicks on JS Alert Button
		page.getJS1().click();
		Alert alert = driverSetup.getDriver().switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		alert.accept();

		// Test clicks on JS confirm Button and clicks ok on alert
		page.getJS2().click();

		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.accept();

		// Test clicks on JS Prompt Button and types a message on Prompt

		page.getJS3().click();

		System.out.println(alert.getText());

		String testtobewritten = "Take Home Test Content";
		Alert alert1 = driverSetup.getDriver().switchTo().alert();
		alert1.sendKeys(testtobewritten);
		alert1.accept();
		Assert.assertTrue(page.getResult().getText().contains(testtobewritten));

	}

	

	public void alternativesoluitonjavascriptalert() {
		page = new JavascriptAlertsPage(driverSetup.getDriver(), driverSetup.getBaseURL());
		for (WebElement element : page.getJSButtons()) {
			if (element.getText().equals("Click for JS Alert")) {
				element.click();
				Alert alert = driverSetup.getDriver().switchTo().alert();
				System.out.println(alert.getText());
				Assert.assertEquals(alert.getText(), "I am a JS Alert");
				alert.accept();
			}
			if (element.getText().equals("Click for JS Confirm")) {
				element.click();
				Alert alert = driverSetup.getDriver().switchTo().alert();
				System.out.println(alert.getText());
				Assert.assertEquals(alert.getText(), "I am a JS Confirm");
				alert.accept();

			}
			if (element.getText().equals("Click for JS Promp")) {
				element.click();
				Alert alert = driverSetup.getDriver().switchTo().alert();
				String testtobewritten = "Take Home Test Content";
				alert.sendKeys(testtobewritten);
				alert.accept();
				Assert.assertTrue(page.getResult().getText().contains(testtobewritten));

			}
		}
	}

	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
	}

}
