package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;


import com.base.Base;
import com.pages.JavaScriptAlertsPage;

public class JavaScriptAlertTest extends Base {
	
	JavaScriptAlertsPage jap;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("JavaScript Alerts")).click();
		jap=new JavaScriptAlertsPage();
	}
	
	@Test
	public void validateTheJsAlertMessage() {
		jap.clickOnJsAlertBtn();
		Assert.assertEquals(jap.getJsAlertMsg(),"I am a JS Alert");
		jap.dismissJsAlert();
	}
	
	@Test
	public void validateTheJsConfirmMessage() {
		jap.clickOnJsConfirmBtn();;
		Assert.assertEquals(jap.getJsConfirmMsg(),"I am a JS Confirm");
		jap.acceptJsConfirm();
	}
	
	@Test
	public void validateUserTypedPromptTextDisplayedUnderTheResultSection() {
		jap.clickOnJsPromptBtn();
		Assert.assertEquals(jap.getJsConfirmMsg(),"I am a JS prompt");
		jap.enterTheMsginPromptTextBox();
		jap.acceptJsPrompt();
		String actualTextDisplayed=jap.getTheUserTypedPromptText();
		Assert.assertEquals(actualTextDisplayed,"You entered: This is user typed the prompt message");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
