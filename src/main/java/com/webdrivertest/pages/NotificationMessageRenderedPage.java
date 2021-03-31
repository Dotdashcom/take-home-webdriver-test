package com.webdrivertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.webdrivertest.utils.ElementUtil;

public class NotificationMessageRenderedPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	public NotificationMessageRenderedPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	By clickNotiMsg = By.xpath("//a[contains(text(),'Notification Messages')]");
	By flashMsg = By.xpath("//div[@id='flash-messages']/div");
	By clickHere = By.linkText("Click here");
	
	public String checkMsg() {
		boolean flag = true;
		while(flag==true) {
			elementUtil.waitForElementPresent(clickHere);
			elementUtil.doClick(clickHere);
			String text = elementUtil.doGetText(flashMsg);
			System.out.println(text);
			WebElement element = driver.findElement(flashMsg);
			if(element.getText().contains("successful")){
				flag=false;
			}	
		}
		return null;
		
	}
	public String verifyMsg() {
		String expectedMessage = "Action successful";
		elementUtil.waitForElementPresent(clickHere);
		elementUtil.doClick(clickHere);
		String successMessage = elementUtil.doGetText(flashMsg);
		if(!successMessage.contains(expectedMessage)){
			retryIfMessageIsNotAsExpected(expectedMessage);
		}
		return successMessage;
	}
	
	private void retryIfMessageIsNotAsExpected(String expectedMessage){
		String message = null;
		for(int i=0; i < 3; i++){
			elementUtil.waitForElementPresent(clickHere);
			elementUtil.doClick(clickHere);
			message = elementUtil.doGetText(flashMsg);
			if (message.contains(expectedMessage)) {
				break;
			}else if (i>=2) {
				Assert.fail("Unable to find success message");
			}
		}
	}
	
	

}
