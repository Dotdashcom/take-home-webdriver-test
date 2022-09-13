package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Util.TestBase;
import pages.JavaScriptAlertPage;

public class JavaScriptAlertTest extends TestBase {
	
	JavaScriptAlertPage jp=new JavaScriptAlertPage();
	
	@BeforeClass
	public void openBrowser() {
		jp.Initialization();
		jp.landingPage();
	}
	@Test(priority=1) 
	public void clickAndVerifyJsAlert() {
		jp.clickJsAlert();//click on Javascript Alert Button
		jp.acceptAlert();
		Assert.assertTrue(jp.verifyMessage().contains("You successfuly clicked an alert"));//verify alert message
	}
	
	@Test(priority=2) 
	public void clickAndVerifyJsConfirm() {
		jp.clickJsConfirm();//click on Javascript confirm Button
		jp.acceptAlert();
		Assert.assertTrue(jp.verifyMessage().contains("You clicked: Ok"));//verify alert message
	}
	@Test(priority=3)
	public void clickAndVerifyJsPrompt(){
		jp.clickJsPrompt("Hello");//click on Javascript prompt Button
		jp.acceptAlert();
		Assert.assertTrue(jp.verifyMessage().contains("You entered: Hello"));//verify alert message
	}
	@AfterClass
	public void afterClass() {
		jp.closeBrowser();//Close the Browser
	}

}
