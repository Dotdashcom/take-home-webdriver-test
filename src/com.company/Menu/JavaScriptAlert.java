package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlert {
	
	@Test(priority = 1)
	public void TestJAlert() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.javaScriptAlertpageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		baseObjectClass.Jalert().click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		
		Assert.assertTrue(baseObjectClass.Jtxt().getText().contains("You successfuly clicked an alert"));
		
		BrowseFactory.tearDown();
		
		
	}
	@Test(priority = 2)
	public void TestJConfirm() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.javaScriptAlertpageUrl);		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		baseObjectClass.Jconfirm().click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
		System.out.println("Text:-"+baseObjectClass.Jtxt().getText());
		
		Assert.assertTrue(baseObjectClass.Jtxt().getText().contains("You clicked: Ok"));
		
		BrowseFactory.tearDown();
		
		
	}
	@Test(priority = 3)
	public void TestJPrompt() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.javaScriptAlertpageUrl);		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		baseObjectClass.Jprompt().click();
	
		
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.sendKeys("Hello");
		alert.accept();
		
		//System.out.println("Text:-"+baseObjectClass.Jtxt().getText()+"Alert Text:"+alert.getText());
		
		Assert.assertTrue(baseObjectClass.Jtxt().getText().contains("Hello"));
		
		BrowseFactory.tearDown();
		
	}

	

}
