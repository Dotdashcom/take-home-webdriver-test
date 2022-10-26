package com.TakeHomeTest.testCases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.DropDownPageObjects;

public class DropdownTest extends BaseClass{

	@Test
	public void dropdown() {
		DropDownPageObjects pageobj=new DropDownPageObjects(driver);
		driver.get(url+"/dropdown");
		
		Select select=new Select(pageobj.Dropdown);
		select.selectByValue("1");
		String selected_value=select.getFirstSelectedOption().getText();
		Assert.assertEquals(selected_value, "Option 1");
		
		select.selectByVisibleText("Option 2");
		String select_value=select.getFirstSelectedOption().getText();
		Assert.assertEquals(select_value, "Option 2");

	}
}
