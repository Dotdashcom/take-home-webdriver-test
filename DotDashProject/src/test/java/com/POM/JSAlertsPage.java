package com.POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSAlertsPage {
	public WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
	WebElement jsAlert;
	String JSAlretText;
	@FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
	WebElement jsConfirm;
	String JSConfirmText;

	@FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
	WebElement jsPrompt;	
	String JSPrompt;

	public JSAlertsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // paageObjectModel using selenium pagefactor
	}

	public void Alerts() throws InterruptedException{
		//For "JS ALert"
		jsAlert.click();
		Alert alert1 =driver.switchTo().alert();
		alert1.accept();


		//for "JS confirm"
		jsConfirm.click();
		Alert alert2 =driver.switchTo().alert();
		alert2.dismiss();


		//for "JS Prompt"
		jsPrompt.click();
		Alert alert3 =driver.switchTo().alert();
		alert3.sendKeys("Hello DotDash");
		Thread.sleep(2000);

		alert3.accept();



	}
}
