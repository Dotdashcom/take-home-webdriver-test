package com.dotdash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotdash.qa.base.TestBase;

public class MouseHoverPage extends TestBase{
	
	
	@FindBy(xpath="//div[@class='example']//div[1]//img[1]")
	WebElement userImage1;
	
	@FindBy(xpath="//div[@class='row']//div[2]//img[1]")
	WebElement userImage2;
	
	@FindBy(xpath="//div[3]//img[1]")
	WebElement userImage3;
	
	
	@FindBy(xpath="//h5[contains(text(),'name: user1')]")
	WebElement user1;
	
	@FindBy(xpath="//h5[contains(text(),'name: user2')]")
	WebElement user2;
	
	@FindBy(xpath="//h5[contains(text(),'name: user3')]")
	WebElement user3;
	
	public MouseHoverPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean mouseHover() {
		Actions act = new Actions(driver);
		act.moveToElement(userImage1);
		act.click().build().perform();
		boolean isUser1Displayed = user1.isDisplayed();
		
		act.moveToElement(userImage2);
		act.click().build().perform();
		boolean isUser2Displayed = user2.isDisplayed();
		
		act.moveToElement(userImage3);
		act.click().build().perform();
		boolean isUser3Displayed = user3.isDisplayed();
		
		if(isUser1Displayed && isUser2Displayed && isUser3Displayed)
			return true;
		else
			return false;
	}
	
	
}
