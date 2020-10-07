package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DynamicControl {
	
	
	@Test(priority = 1)
	public void TestDynamicControl() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.dynamicContentPageUrl);		
		driver.navigate().refresh();
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		
		if(baseObjectClass.dynamicCheck().isDisplayed())
		{
			baseObjectClass.dynamicAR().click();
			WebDriverWait wait= new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(baseObjectClass.DynamicText()));
			Assert.assertTrue(baseObjectClass.DynamicText().getText().contains("It's gone!"));
		}
		else
		{
			baseObjectClass.dynamicAR().click();
			WebDriverWait wait= new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.visibilityOf(baseObjectClass.DynamicText()));
			Assert.assertTrue(baseObjectClass.DynamicText().getText().contains("It's back!"));
		}
		
		Thread.sleep(5000);
		BrowseFactory.tearDown();
	
	}
	@Test(priority = 2)
	public void TestDynamicControlEnable() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.dynamicContentPageUrl);		
		driver.navigate().refresh();
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		
		if(baseObjectClass.DynamicTextBox().isEnabled())
		{
			baseObjectClass.DynamicBtnED().click();
			WebDriverWait wait= new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.visibilityOf(baseObjectClass.DynamicText()));
			Assert.assertTrue(baseObjectClass.DynamicText().getText().contains("It's disabled!"));
		}
		else
		{
			baseObjectClass.DynamicBtnED().click();
			WebDriverWait wait= new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.visibilityOf(baseObjectClass.DynamicText()));
			Assert.assertTrue(baseObjectClass.DynamicText().getText().contains("It's enabled!"));
		}
		
		Thread.sleep(5000);
		BrowseFactory.tearDown();
		
	
	}


}
