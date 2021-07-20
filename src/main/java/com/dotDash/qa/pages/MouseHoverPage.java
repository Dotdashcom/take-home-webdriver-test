package com.dotDash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dotDash.qa.base.TestBase;

public class MouseHoverPage extends TestBase{
	//Instantiating  action class
	Actions actions = new Actions(driver);
	
		//Finding the link to the Hover page
		@FindBy(xpath= "//a[@href='/hovers']")  
		WebElement hover;
		
		//Finding the element that is displayed when mouse hover
		@FindBy(className = "figcaption")
		WebElement caption;
		
		//Finding first image
		@FindBy(xpath="//img[@src='/img/avatar-blank.jpg']") 
		WebElement image1;
		
		//Initializing the Page Objects:
		public MouseHoverPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		public boolean mouseHover(){
			hover.click();
			actions.moveToElement(image1).perform();
			boolean captionVisible  = caption.isDisplayed();
			return captionVisible;
		}
}
