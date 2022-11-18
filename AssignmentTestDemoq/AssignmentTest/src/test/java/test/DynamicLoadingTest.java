package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DynamicLoadingPage;

public class DynamicLoadingTest extends TestBaseAssignment{

	@Test
	@Parameters({"DynamicLoadingUrl"})
	public void DynamicLoadingTestCase(String DynamicLoadingUrl) throws InterruptedException{
		this.helper.getDriver().get(DynamicLoadingUrl);
		this.helper.maximizeWindows();
		
		DynamicLoadingPage dl = new DynamicLoadingPage(this.helper.getDriver(), helper);
		
		dl.ClickStartButton();
		dl.VerifyHelloWorld("Hello World!");
	}
}
