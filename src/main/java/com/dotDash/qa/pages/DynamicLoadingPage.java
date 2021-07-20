package com.dotDash.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotDash.qa.base.TestBase;

public class DynamicLoadingPage extends TestBase{
	
	// Finding the link to the dynamic loading page
		@FindBy(xpath = "//a[@href='/dynamic_loading']")
		WebElement dynamicLoading;

		// Finding the link to go to the hidden element page
		@FindBy(xpath = "//a[@href='/dynamic_loading/1']")
		WebElement hiddenElement;
		
		//Finding the start button
		@FindBy(xpath = "/html/body/div[2]/div/div/div[1]/button")
		WebElement startBtn;
		
		//Finding the link to go to the adding the element page
		@FindBy(xpath = "//a[@href='/dynamic_loading/2']")
		WebElement addingElement;
		
		//Initializing the Page Objects:
		public DynamicLoadingPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		
		public boolean hiddenElement(){
			dynamicLoading.click();
			hiddenElement.click();
			startBtn.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
			wait.until(ExpectedConditions.textToBe(By.id("finish"), "Hello World!"));
			boolean visible = driver.findElements( By.id("finish") ).size() == 0;
			return visible;
		}
		
		public boolean addingElemnt(){
			dynamicLoading.click();
			addingElement.click();
			startBtn.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
			wait.until(ExpectedConditions.textToBe(By.id("finish"), "Hello World!"));
			boolean visible = driver.findElements( By.id("finish") ).size() == 0;
			return visible;
 
			
		}
		
}
