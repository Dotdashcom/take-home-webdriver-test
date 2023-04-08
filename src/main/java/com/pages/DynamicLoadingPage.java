package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;

public class DynamicLoadingPage extends Base{
	
	@FindBy(xpath="//div[@id='start']//button")
	WebElement startBtn ;
	
	@FindBy(xpath="//h4[normalize-space()='Hello World!']")
	WebElement helloWorldText ;
	
	public DynamicLoadingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnStartBtn() {
		startBtn.click();
	}
	public boolean checkHelloWorldTextIsPresent() {
		boolean flag=helloWorldText.isDisplayed();
		return flag;
		
	}
	public void explicitWait() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(helloWorldText, "Hello World!"));
	}

}
