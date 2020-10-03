package testcases;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class MouseHoverTest extends TestBase{
	
	BrowseData data;
	BaseUrl urlvalues;
	public MouseHoverTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}
	
	@Test  
	public void verifyMouseHover() throws InterruptedException
	{
		driver.get(urlvalues.url_hover);
		Actions actions = new Actions(driver);
		int i=0;
		for(WebElement element : data.mousehover)
		{
			//handle the mousehover using Actions's class 
			actions.moveToElement(element).build().perform();
			Thread.sleep(2000);	
			Assert.assertTrue(data.additionallist.get(i).isDisplayed());
			System.out.println(data.additionallist.get(i).getText());		
			i++;
		}
		System.out.println("text is displayed as per image selected");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
