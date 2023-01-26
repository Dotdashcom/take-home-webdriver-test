package com.qa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class DynamicContentPage extends TestBase {

	@FindBy (xpath ="//div[@class =\"large-10 columns large-centered\"]/div[1]/div[1]/img")
	WebElement firstBox;
	

	@FindBy (xpath ="//div[@class =\"large-10 columns large-centered\"]/div[2]/div[1]/img")
	WebElement secondBox;
	
	@FindBy (xpath ="//div[@class =\"large-10 columns large-centered\"]/div[3]/div[1]/img")
	WebElement thirdBox;
	
	
	
	
	public DynamicContentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String checkFirstbox() {
		return firstBox.getAttribute("src");
	}
	public String checkSecondbox() {
		return secondBox.getAttribute("src");
	}
	public String checkThirdbox() {
		return thirdBox.getAttribute("src");
	}
	
	
	
	
}
