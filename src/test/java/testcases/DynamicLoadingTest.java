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

public class DynamicLoadingTest extends TestBase {
	
	BrowseData data;
	BaseUrl urlvalues;
	public DynamicLoadingTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}
	
	@Test 
	public void verifyDynamicLoading()
	{
		
		//Use ExplicitWait here and validate the result
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		driver.get(urlvalues.url_dynamicloading);
		data.startButton.click();
		wait.until(ExpectedConditions.invisibilityOf(data.loadingicon));
		String s1 =data.hellotext.getText();
		String s2 = "Hello World!";
		Assert.assertEquals(s1, s2);
		System.out.println("“Hello World!” text is displayed");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
