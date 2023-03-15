package com.dotdash.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.dotdash.testUtils.TestBase;

public class DynamicLoadingPOM extends TestBase {
	
	
	
	@FindBy(css="div#start>button")
	WebElement startButton;
	
	@FindBy(css="div#finish>h4")
	WebElement helloWorldTxt;
	
	
	public DynamicLoadingPOM() {
		PageFactory.initElements(driver,this);
	}
	public void userclickStart() {
		
		startButton.click();
	}
	
	public void userverifyHelloWord() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(helloWorldTxt));		
		
	}
	
	public void userverifyhelloWordText() {
		String hello=helloWorldTxt.getText();
		System.out.println(helloWorldTxt.getText());
		Assert.assertEquals(hello, (prop.getProperty("helloworldText")).trim());
	}

}
