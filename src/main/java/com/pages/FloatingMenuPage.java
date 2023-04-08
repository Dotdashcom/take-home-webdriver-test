package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class FloatingMenuPage extends Base{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(xpath="//body/div/div/div/div[1]")
	WebElement floatingMenu;
	
	public FloatingMenuPage() {
		PageFactory.initElements(driver, this);
	}

	public void scrollToMiddleOfTheWebPage() {
		js.executeScript("window.scrollTo(0,1000)");
	}

	
	public void scrollToBottomOfTheWebPage() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public boolean validateFloatingMenuIsDisplayed() {
		boolean flag=floatingMenu.isDisplayed();
		return flag;
	}

}
