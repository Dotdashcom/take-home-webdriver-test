package testcases;

import java.io.IOException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class ContextMenuTest extends TestBase{

	BrowseData data;
	BaseUrl urlvalues;
	public ContextMenuTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {	
		
		//ivoking browser and driver properties by calling initialization method
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}
	
	@Test
	public void verifyContextMenu()
	{
		driver.get(urlvalues.url_ContextMenu);
		
		//using Actions class perform right  click operation 
		Actions actions = new Actions(driver);
		actions.contextClick(data.contextMenu).build().perform();
		
		//switching the Webdriver to alert mode 
		String alertmsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expectedmsg = "You selected a context menu";
		Assert.assertEquals(alertmsg, expectedmsg);
		System.out.println("successfully right click on ContextMenu");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
