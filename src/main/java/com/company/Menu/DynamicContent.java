package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DynamicContent {
	

	WebDriver driver;
	@Test
	public void TestDynamicContent() throws Exception
	{
		
		BrowseFactory.setUp();
		driver=BrowseFactory.StartBrowser(BaseUrl.dynamicContentPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		String first=baseObjectClass.contentOne().getText();
		String two=baseObjectClass.contentTwo().getText();
		String three=baseObjectClass.contentThree().getText();
		driver.navigate().refresh();
		//boolean status=BrowserFactory.verifyContentChange(baseObjectClass.contentOne());
		Thread.sleep(2000);
		Assert.assertTrue(!first.equalsIgnoreCase(baseObjectClass.contentOne().getText()));
		Assert.assertTrue(!two.equalsIgnoreCase(baseObjectClass.contentTwo().getText()));
		Assert.assertTrue(!three.equalsIgnoreCase(baseObjectClass.contentThree().getText()));
		//System.out.println(baseObjectClass.contentOne().getText());
		
		BrowseFactory.tearDown();
		
	}
	


}
