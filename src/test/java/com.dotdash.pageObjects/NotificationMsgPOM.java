package com.dotdash.pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.dotdash.testUtils.TestBase;

public class NotificationMsgPOM extends TestBase {

	@FindBy(css="div.example>p>a")
	WebElement clickHereLink;
	
	@FindBy(css="div#flash")
	WebElement notiMsg;	
	
	public NotificationMsgPOM() {
		PageFactory.initElements(driver,this);
	}
	public void userClickhere() {
		clickHereLink.click();
		
	}
	
	public void checkForNotiMsg() {
		boolean msg1=false;
		int counter=0;
		String successMsg, unsuccessMsg, notiMessage;
		successMsg=prop.getProperty("successMsg");
		unsuccessMsg=prop.getProperty("unsuccessMsg");
		ArrayList<String>msgArray= new ArrayList();
		msgArray.add(successMsg);
		msgArray.add(unsuccessMsg);
		
		while((msg1==false)) {
			clickHereLink.click();
			for(String msg:msgArray ) {
			notiMessage=notiMsg.getText();		
			if(notiMessage.contains(msg))
			{  msg1=true;
				}
			}			
		}	
		Assert.assertTrue(msg1);
		
	}
	   
}
