package com.dotDash.qa.pages;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dotDash.qa.base.TestBase;

public class NewTabPage extends TestBase {
	
	// Instantiating action class
	Actions actions = new Actions(driver);

	// Finding the link to the context Menu page
	@FindBy(xpath = "//a[@href='/windows']")
	WebElement newTabPage;
	
	//Finding the link to the new tab
	@FindBy(xpath = "/html/body/div[2]/div/div/a")
	WebElement newTab;
	
	//Finding the text on the new tab
	@FindBy(className = "example")
	WebElement newText;

	// Initializing the Page Objects:
	public NewTabPage(){
			PageFactory.initElements(driver, this);
		}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public String switchTab() {
		newTabPage.click();
		newTab.click();
	
		Iterator<String> tabIterator = driver.getWindowHandles().iterator();
		String parentTab = tabIterator.next();
		String childTab = tabIterator.next();
		driver.switchTo().window(childTab);
		
		String newTabText = driver.findElement(By.tagName("h3")).getText();
		driver.switchTo().window(parentTab);
		return newTabText;

	}
}
