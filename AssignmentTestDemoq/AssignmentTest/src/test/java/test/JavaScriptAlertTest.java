package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.JavaScriptAlertPage;

public class JavaScriptAlertTest extends TestBaseAssignment {
	
	@Test
	@Parameters({"JavaScriptAlertUrl"})
	public void ClickAlertAndVerifyAlertTextTestCase(String JavaScriptAlertUrl) throws InterruptedException{
		this.helper.getDriver().get(JavaScriptAlertUrl);
		this.helper.maximizeWindows();
		
		JavaScriptAlertPage js = new JavaScriptAlertPage(this.helper.getDriver(), helper);
		
		js.ClickButton("Alert");
		js.VerifyAlertText("I am a JS Alert");
		helper.AcceptAlert();
		
		js.ClickButton("Confirm");
		js.VerifyAlertText("I am a JS Confirm");
		helper.AcceptAlert();
		
		js.ClickButton("Prompt");
		js.VerifyAlertText("I am a JS prompt");
		helper.AcceptAlert();
		
		}
		

}
