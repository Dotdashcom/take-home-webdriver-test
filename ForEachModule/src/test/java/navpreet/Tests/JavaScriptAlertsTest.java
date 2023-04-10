package navpreet.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import navpreet.pageobjects.JavaScriptAlertsPageObjects;
import navpreet.util.ObjectsOfClasses;



public class JavaScriptAlertsTest extends ObjectsOfClasses {

	ObjectsOfClasses base_instance;
	JavaScriptAlertsPageObjects japo;
	String alert_message,end_message;
	
	
	
	
	@Test(description="Test Clicks on JS Alert Button.Test asserts alert message.")
	public void TestJsAlertButton() throws IOException
	{
		japo=javaScriptAlertsApplication();
		japo.ClickAlert();
		japo.clickOnJsAlertBtn();
		String alert_message=japo.acceptJsAlert();
		System.out.println(alert_message);
		Assert.assertEquals(alert_message, "I am a JS Alert");
		end_message=japo.CheckMessage();
		Assert.assertEquals(end_message,"You successfuly clicked an alert");
	}
	
	@Test(description="Test clicks on JS confirm Button and clicks ok on alert.Test asserts the alert message.")
	public void TestJsConfirm() throws IOException
	{
		japo=javaScriptAlertsApplication();
		japo.ClickAlert();
		alert_message=japo.ClickJsConfirm("ok");
		Assert.assertEquals(alert_message, "I am a JS Confirm");
		end_message=japo.CheckMessage();
		Assert.assertEquals(end_message,"You clicked: Ok");
		alert_message=japo.ClickJsConfirm("cancel");
		Assert.assertEquals(alert_message, "I am a JS Confirm");
		end_message=japo.CheckMessage();
		Assert.assertEquals(end_message,"You clicked: Cancel");
		
	}
	
	@Test(description="Test clicks on JS Prompt Button and types a message on Prompt.Test asserts that the alert message contains the typed message.")
	public void TestJsPrompt() throws IOException
	{
		japo=javaScriptAlertsApplication();
		japo.ClickAlert();
		alert_message=japo.ClickJSPrompt("ok","Hi! I'm from textbox");
		Assert.assertEquals(alert_message, "I am a JS prompt");
		end_message=japo.CheckMessage();
		Assert.assertEquals(end_message,"You entered: Hi! I'm from textbox");
		alert_message=japo.ClickJSPrompt("cancel","");
		end_message=japo.CheckMessage();
		Assert.assertEquals(end_message,"You entered: null");
	}
}
