package tests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.TestBase;
import graphql.Assert;
import pages.JavaScriptErrorPage;

public class JavaScriptErrorTest extends TestBase {
	JavaScriptErrorPage jp=new JavaScriptErrorPage();
	
	@FindBy(xpath="//body[@onload='loadError()']")
	WebElement Error;

	@BeforeClass
	public void openBrowser() {
		jp.Initialization();
		jp.landingPage();//Navigate to landing page
	}
	
	@Test
	public void verifyError() {
		Assert.assertTrue(jp.verifyError().contains("This page has a JavaScript error in the onload event."));
	}
	
	@AfterClass
	public void afterClass() {
		jp.closeBrowser();//Close the Browser
	}
}