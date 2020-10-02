package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenu {
	
	@Test
	public void TestFloatingMenuWithScrollDown() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.floatingMenuPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;	
 
        //This will scroll the web page till end.		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertTrue(baseObjectClass.floatingMenu().isDisplayed(),"Floating Menu is displaying");
        Thread.sleep(5000);
		BrowseFactory.tearDown();
		
		
	}
	

}
