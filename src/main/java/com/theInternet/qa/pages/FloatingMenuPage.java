package com.theInternet.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FloatingMenuPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='menu']")
	WebElement floatingMenu;
	
	 @FindBy(id ="page-footer")
	   WebElement page_Footer;
	 
	 public FloatingMenuPage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	    }
	 
	 
	 public void VerifyFloatingMenudisplay()
	 {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",page_Footer);
		 Assert.assertTrue(floatingMenu.isDisplayed(), "Floating not displayed as expected");
	 }
}
