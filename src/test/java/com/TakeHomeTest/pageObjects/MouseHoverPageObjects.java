package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPageObjects {

	WebDriver ldriver;
	
	public MouseHoverPageObjects(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@id='content']//div[1]/img")
	private WebElement image1;
	
	@FindBy(xpath="//div[@id='content']//div[1]/div/h5")
	private WebElement user1;
	
	@FindBy(xpath="//div[@id='content']//div[2]/img")
	private WebElement image2;
	
	@FindBy(xpath="//div[@id='content']//div[2]/div/h5")
	private WebElement user2;

	@FindBy(xpath="//div[@id='content']//div[3]/img")
	private WebElement image3;
	
	@FindBy(xpath="//div[@id='content']//div[3]/div/h5")
	private WebElement user3;
	
	public void hoverimage1() {
		Actions actions =new Actions(ldriver);
		actions.moveToElement(image1).perform();
	}
	
	public String user1details() {
		String user1detail=user1.getText();
		return user1detail;
	}
	
	public void hoverimage2() {
		Actions actions =new Actions(ldriver);
		actions.moveToElement(image2).perform();
	}
	
	public String user2details() {
		String user2detail=user2.getText();
		return user2detail;
	}
	
	public void hoverimage3() {
		Actions actions =new Actions(ldriver);
		actions.moveToElement(image3).perform();
	}
	
	public String user3details() {
		String user3detail=user3.getText();
		return user3detail;
	}
	
}
