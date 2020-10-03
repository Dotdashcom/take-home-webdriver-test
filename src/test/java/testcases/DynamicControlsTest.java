package testcases;

import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class DynamicControlsTest extends TestBase {
	
	BrowseData data;
	BaseUrl urlvalues;
	public DynamicControlsTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}
	
	@Test
	public void verifyDynamicControls()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		driver.get(urlvalues.url_controls);
		data.removebutton.click();
		
		//use ExplicitWait here on specific condition 
		wait.until(ExpectedConditions.elementToBeClickable(data.addbutton));
		
		String actual = data.textmsg.getText();
		String Expected = "It's gone!";
		Assert.assertEquals(actual, Expected);
		System.out.println("checkbox is gone");
		data.addbutton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(data.checkbox));
		data.enablebutton.click();
		wait.until(ExpectedConditions.elementToBeClickable(data.textbox));
		String s1 = data.msg1.getText();
		String s2 = "It's enabled!";
		Assert.assertEquals(s1, s2);
		System.out.println("text box is enabled ");
		data.disablebutton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(data.enablebutton));
		String text1 = data.msg1.getText();
		String text2 = "It's disabled!";
		Assert.assertEquals(text1,text2);
		System.out.println("Textbox is displayed");		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
