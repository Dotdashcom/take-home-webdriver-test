package com.qa.selenium.pages;


import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;
import com.qa.selenium.util.TestUtil;

public class IFramePage extends TestBase{
	
	@FindBy (xpath = "//body[@id='tinymce']/p")
	WebElement frameTextbox;
	
	@FindBy (xpath = "//div[@class = 'tox-icon']")
	WebElement alertclose;
	
	
	@FindBy (css= "#tinymce")
	WebElement textCheck;
	
	
	public IFramePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void frameSwitch() {
	//	List <WebElement> f= driver.findElements(By.tagName("iframe"));
		
		try{
			driver.switchTo().frame("mce_0_ifr");

		}
			catch(NoSuchFrameException e) {
			e.printStackTrace();
		}
			}
		
		
		 
	
	
	public void write() throws InterruptedException {
		alertclose.click();
		frameSwitch();
		Thread.sleep(1000);
	//	frameTextbox.click();
		TestUtil.iFrameText();
		frameTextbox.sendKeys(prop.getProperty("FrameText"));
		
		
	}
	
	public String verifyText() {
		return textCheck.getText();
		
	}
	
	


}
