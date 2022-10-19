package testpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseTest;
import pagepackage.iFrame;

public class iframetest extends BaseTest{

	public iframetest() {
		super();
	}
	

	@BeforeMethod
	public void StartSignInTest() throws InterruptedException {
		initiate();
		driver.get(prop.getProperty("iframeurl"));
		Thread.sleep(1000);
		frame = new iFrame();
	}
	
	iFrame frame;
	
	
	@Test
	public void Frametest() {
		frame.iframe();
	}
	
	@AfterMethod
	public void EndSignInTest() {
		quitbrowser();
}
}