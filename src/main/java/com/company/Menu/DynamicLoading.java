package com.company.Menu;


import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DynamicLoading {
	
	
	@Test
	public void TestDynamicLoading() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.dynamicLoadingPageUrl);		
	
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		baseObjectClass.dynamicL().click();
		
		WebDriverWait wait= new WebDriverWait(driver, 20);
		WebElement element=wait.until(ExpectedConditions.visibilityOf(baseObjectClass.dynamicTxt()));
		Assert.assertTrue(element.isDisplayed());
		Thread.sleep(5000);
		BrowseFactory.tearDown();
		
		
		
		
		
		
		
		
	}

}
