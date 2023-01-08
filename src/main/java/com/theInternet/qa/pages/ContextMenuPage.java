package com.theInternet.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContextMenuPage {
	
	WebDriver driver;
	
		@FindBy(id="hot-spot")
		WebElement box_on_page;
		
		public ContextMenuPage(WebDriver driver)
		{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
		
		public void VerifyContextMenuAlert()
		{
			Actions action=new Actions(driver);
			action.contextClick(box_on_page).perform();
		String Alert_Message=driver.switchTo().alert().getText();
		Assert.assertEquals(Alert_Message,"You selected a context menu");
		driver.switchTo().alert().accept();
		}

}
