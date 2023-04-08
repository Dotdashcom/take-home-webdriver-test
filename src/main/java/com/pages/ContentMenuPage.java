package com.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;

public class ContentMenuPage extends Base{
	@FindBy(xpath="//*[@id='hot-spot']")
	WebElement contextMenuBox;
	
	@FindBy(id="column-b")
	WebElement elementB;
	
	@FindBy(xpath="//*[@id='column-a']/header")
	WebElement column_a_header;
	
	@FindBy(xpath="//*[@id='column-b']/header")
	WebElement column_b_header;
	
	
	
	public ContentMenuPage() {
		PageFactory.initElements(driver, this);
	}
	public void rightClickContentMenu() {
		Actions rightClickAction=new Actions(driver);
		rightClickAction.contextClick(contextMenuBox).perform();
	}
	
	public void explicitWait() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.alertIsPresent());
	}
	public String getTheAlertMessag() {
		Alert jsAlert= driver.switchTo().alert();
        String actualAlertMsg=jsAlert.getText();
        return actualAlertMsg;

	}

}
