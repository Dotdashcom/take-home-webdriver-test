package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class IframeTest extends TestBase{
	
	BrowseData data;
	BaseUrl urlvalues;
	public IframeTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}

	@Test  
	public void verifyIframe()
	{
		driver.get(urlvalues.url_iframe);
		
		//handle the frames using SwitchTo() method 
		driver.switchTo().frame(data.iframe);
		
		data.framebody.clear();
		data.framebody.sendKeys("hello everyone");
		String s1 = data.framebody.getText();
		String s2 = "hello everyone";
		Assert.assertEquals(s1, s2);
		System.out.println("text has been printed from IFrame");	
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
