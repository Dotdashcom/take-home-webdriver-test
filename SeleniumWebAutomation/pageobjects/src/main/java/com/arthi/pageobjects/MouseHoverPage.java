package com.arthi.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.arthi.automation.common.PageBase;

/**
 * 
 * @author Arthina Kumar
 *
 */

public class MouseHoverPage extends PageBase {
	
	private static final String Base_Url = "http://localhost:7080/hovers";
	
	@FindBy(xpath="//div[@class='figure']")
	private List<WebElement> user;
	
	@FindBy(xpath="//div[@class='figcaption']//a")
	private List<WebElement> userProfileLbl;
	
	
	public MouseHoverPage(WebDriver driver) {
		super(driver);	
	}
	
	

	public MouseHoverPage navigateToMouseHoverPage() {
		driver.get(Base_Url);
		return this;
		
		
	}
			
	public MouseHoverPage checkMouseEvent() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		for(int i=0;i<user.size();i++) {
			actions.moveToElement(user.get(i)).build().perform();
			Thread.sleep(2000);
			actions.contextClick(userProfileLbl.get(i));
		}
		System.out.println("Move hover done sucessfully");
		
		return this;
		
	}
		
		
		
}
