package com.theInternet.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IFramePage {
	WebDriver driver;
	
	@FindBy(css="iframe[id*='ifr']")
	WebElement frame_element;
	
	@FindBy(css="body#tinymce")
	WebElement frame_txt;
	
	public IFramePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
	
	public void VerifyIframeText()
	{
		driver.switchTo().frame(frame_element);
		frame_txt.clear();
		frame_txt.sendKeys("Sending text to text frame");
		Assert.assertEquals(frame_txt.getText(), "Sending text to text frame");
		
	}
}
