package com.POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextClickPage  {
	public WebDriver driver;
	Alert alert;

	public ContextClickPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// paageObjectModel using selenium pagefactory

	}


	@FindBy (xpath = "//div[@id='hot-spot']")
	WebElement we;

	public void contextClick(){
		Actions ac = new Actions(driver);
		ac.contextClick(we).perform();
	}

	public String alert(){
		alert = driver.switchTo().alert();
		String message = alert.getText();
		alert.accept();
		return message;
	}
}