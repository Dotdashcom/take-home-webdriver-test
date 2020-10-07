package com.company.Menu;

import com.company.Base.BaseObjectClass;
import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDown {
	
	@Test(priority = 1)
	public void validateoption1() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.dropDownPageUrl);
		
		
		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		Select select=new Select(baseObjectClass.DropDown());
		select.selectByVisibleText("Option 1");
		WebElement ele1=select.getFirstSelectedOption();
		String text=ele1.getText();
		Assert.assertTrue(text.equalsIgnoreCase("Option 1"));
		System.out.println(text);
		BrowseFactory.tearDown();
	}
	@Test(priority = 2)
	public void validateoption2() throws Exception
	{
		
		BrowseFactory.setUp();
		WebDriver driver=BrowseFactory.StartBrowser(BaseUrl.dropDownPageUrl);		
		

		BaseObjectClass baseObjectClass=new BaseObjectClass(driver);
		Select select=new Select(baseObjectClass.DropDown());
		select.selectByVisibleText("Option 2");
		WebElement ele1=select.getFirstSelectedOption();
		String text=ele1.getText();
		Assert.assertTrue(text.equalsIgnoreCase("Option 2"));
		System.out.println(text);
		BrowseFactory.tearDown();
	}

}
