package testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class OpenInNewTabTest extends TestBase{
	BrowseData data;
	BaseUrl urlvalues;
	public OpenInNewTabTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}
	
	@Test  
	public void verifyNewTab()
	{
		driver.get(urlvalues.url_newwindow);
		data.newWindow.click();
		
		//use the Window Handles to switch from one window to other 
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String mainwindow = it.next();
		String childwindow = it.next();
		
		//redirect the webdriver to other window
		driver.switchTo().window(childwindow);
		String s1 = data.newmessage.getText();
		String s2 = "New Window";
		Assert.assertEquals(s1, s2);
		System.out.println("new tab is opened with text New Window");
		}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
