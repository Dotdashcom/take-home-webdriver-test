package testpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.JSAlert;

public class JSAlertTest extends BaseTest {

	public JSAlertTest() {
		super();
	}
	
	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("jsalerturl"));
		Thread.sleep(1000);
		jsalert = new JSAlert();
	}
	
	JSAlert jsalert;
	@Test
	public void jsalerttest() {
		jsalert.Alert();
	}
	
	@Test
	public void jsconfirmtest() {
		jsalert.Confirm();
	}
	
	@Test
	public void jsprompttest() {
		jsalert.Prompt();
	}
	
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
}
}
