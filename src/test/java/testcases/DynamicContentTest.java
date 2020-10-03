package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.BrowseData;
import testdata.BaseUrl;

public class DynamicContentTest extends TestBase {
	
	BrowseData data;
	BaseUrl urlvalues;
	public DynamicContentTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {		 
		initialization();		
		data =new BrowseData();
		urlvalues = new BaseUrl();
	}
	
	@Test(priority=6)
	public void verifyDynamicContent()
	{
		boolean flag = false ;
		driver.get(urlvalues.url_dynamic);
		
		//get the dynamic text in string variable
		String v1 =data.dynamictext.getText();
		
		//click on the button to refresh the page everytime 
		data.linkbtn.click();
		
		//get the dynamic text in string variable
		String v2 = data.dynamictext.getText();
		data.linkbtn.click();
		String v3 = data.dynamictext.getText();
		
		//compare the condition 
		if(v1.equals(v2)==false && v2.equals(v3)==false)
		{
			flag = true;
			Assert.assertTrue(flag);
			System.out.println("Test content changes with page reload");
		}
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}


}
