package com.dotDash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotDash.qa.base.TestBase;

public class DynamicContentPage extends TestBase{
	
	//Finding the link to the Dynamic Content page
	@FindBy(xpath= "//a[@href='/dynamic_content']")  
	WebElement dynamicContent;
	
	@FindBy(xpath= "/html/body/div[2]/div/div/div/div/div[1]/div[2]")
	WebElement text;
	//Initializing the Page Objects:
	public DynamicContentPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public String dynamicContent(){
		dynamicContent.click();
		String dynamicText = text.getText();
		driver.navigate().refresh();
		return dynamicText;
	}

}
