package com.TakeHomeTest.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.JavaScriptAlertsPageObjects;

public class JavaScriptAlertTest extends BaseClass{

	@Test
	public void alerts() {
		JavaScriptAlertsPageObjects jsalertpage=new JavaScriptAlertsPageObjects(driver);
		driver.get(url+"/javascript_alerts");
		
		jsalertpage.ClickAlert();
		String checkresult=jsalertpage.Resultmsg();
		Assert.assertEquals(checkresult, "You successfuly clicked an alert");
		
		jsalertpage.ClickConfirmAlert();
		String checkresult2=jsalertpage.Resultmsg();
		Assert.assertEquals(checkresult2, "You clicked: Cancel");
		
		jsalertpage.ClickPromptAlert();
		String checkresult3=jsalertpage.Resultmsg();
		Assert.assertEquals(checkresult3, "You entered: text entered in the prompt box");
	}
}
