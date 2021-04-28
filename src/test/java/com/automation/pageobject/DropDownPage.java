package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownPage {
	public static final By DROPDOWNHEADER=By.xpath("//h3[text()='Dropdown List']");
	public static final By SELECTELEMENT=By.id("dropdown");
	public static void validateDropDownHeader(WebDriver driver) {
		WebElement element= driver.findElement(DROPDOWNHEADER);
		Assert.assertTrue(element.isDisplayed(), "Drop down header is not Displaying");

	}
	
	public static void selectDropDown(WebDriver driver,String option) throws InterruptedException {
		Select select = new Select(driver.findElement(SELECTELEMENT));
		select.selectByVisibleText(option);
		Thread.sleep(1000);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), option);
		
		
	}
}
