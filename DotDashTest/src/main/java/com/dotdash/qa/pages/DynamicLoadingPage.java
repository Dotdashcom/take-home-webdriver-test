package com.dotdash.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotdash.qa.base.TestBase;

public class DynamicLoadingPage extends TestBase{
	
	@FindBy(xpath="//button[contains(text(),'Start')]")
	WebElement startBtn;
	
	public DynamicLoadingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayTextTest() {
		startBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 
		// Here we will wait until element is not visible, if element is visible then it will return web element
		// or else it will throw exception
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
		boolean b = element.isDisplayed();
		System.out.println("Is Text Dispalying : " + b);
		return b;
	}

}
