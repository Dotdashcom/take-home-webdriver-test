package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseHover {
	
	@Test(priority = 1)
	public void TestMouseHover1() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.mouseHoverPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);

		Actions actions=new Actions(driver);
		actions.moveToElement(baseObjectClass.img1()).perform();;
		Thread.sleep(5000);
		Assert.assertTrue(baseObjectClass.img1d().isDisplayed(),"Image1 detail is displaying");
		
		BrowseFactory.tearDown();
		
		
	}
	@Test(priority = 2)
	public void TestMouseHover2() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.mouseHoverPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(baseObjectClass.img2()).perform();
		Assert.assertTrue(baseObjectClass.img2d().isDisplayed(),"Image2 detail is displaying");
		Thread.sleep(5000);
		BrowseFactory.tearDown();
		
		
	}
	@Test(priority = 3)
	public void TestMouseHover3() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.mouseHoverPageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(baseObjectClass.img3()).perform();
		Assert.assertTrue(baseObjectClass.img3d().isDisplayed(),"Image3 detail is displaying");
		Thread.sleep(5000);
		BrowseFactory.tearDown();
		
		
	}
	

}
