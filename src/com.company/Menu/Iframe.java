package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframe {
	
	@Test
	public void TestIFrame() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.iFramePageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		
		driver.switchTo().frame("mce_0_ifr");
		baseObjectClass.Iframe().clear();
		baseObjectClass.Iframe().sendKeys("Hello World");
        Assert.assertTrue(baseObjectClass.Iframe().getText().contains("Hello World"),"Text is matching");
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
		BrowseFactory.tearDown();
		
		
	}
	

}
