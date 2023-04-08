package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class NotificationMessagePage extends Base{
	
	@FindBy(linkText="Click here")
	WebElement clickHereBtn;
	
	@FindBy(xpath="//div[@id='flash']")
	WebElement getTheActionMessage;
	
	public NotificationMessagePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickonClickHereBtn() {
			clickHereBtn.click();
	}
	
	public String getNotificationMessage() {
		String notificationMsg=getTheActionMessage.getText();
		return notificationMsg;
	}
	public void clickOnClickBtnUntilDesiredNotificationMsgIsDisplayed(String notificationMessage) throws InterruptedException{
		boolean flag = true;
		while(flag==true) {
			clickHereBtn.click();
			if(getTheActionMessage.getText().contains(notificationMessage)) {
				flag = false;
			}
		}
		Thread.sleep(2000);
		
		}
	public String expectedSuccessMessage() {
		String expectedSuccessMessage="Action successful"+"\n"+"×";
		return expectedSuccessMessage;
	}
	public String expectedUnsuccessMessage() {
		String expectedUnsuccessMessage="Action unsuccesful, please try again"+"\n"+"×";
		return expectedUnsuccessMessage;
	}
}

