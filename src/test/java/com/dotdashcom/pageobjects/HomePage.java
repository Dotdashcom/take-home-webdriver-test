package com.dotdashcom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[contains(text(),'Secure Area')]")
	private WebElement secureArea;
	
	@FindBy(xpath="//a[@class='button secondary radius']")
	private WebElement logoutBtn;
	
	public boolean isHeadingDisplay() {
		return secureArea.isDisplayed();
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}
}
