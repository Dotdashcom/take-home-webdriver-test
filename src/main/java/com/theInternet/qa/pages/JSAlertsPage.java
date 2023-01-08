package com.theInternet.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JSAlertsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='Click for JS Alert']")
	WebElement JSAlert_btn;
	
	@FindBy(xpath = "//button[text()='Click for JS Confirm']")
    public WebElement JSConfirm_btn;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    public WebElement JSPrompt_btn;


    @FindBy(id = "result")
    public WebElement resultTxt;
    
    public JSAlertsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public void VerifyJSAlertMessage()
    {
    	JSAlert_btn.click();
    	driver.switchTo().alert().accept();
    	Assert.assertTrue(resultTxt.getText().equalsIgnoreCase("You successfuly clicked an alert"), "Alert message not displayed as expected");
    	JSConfirm_btn.click();
    	driver.switchTo().alert().accept();
    	Assert.assertTrue(resultTxt.getText().equalsIgnoreCase("You clicked: Ok"),"Confirm Alert message not displayed as expected");
    	JSPrompt_btn.click();
        Alert alert =driver.switchTo().alert();
        alert.sendKeys("Propmt");
        alert.accept();
        Assert.assertTrue(resultTxt.getText().equalsIgnoreCase("You entered: propmt"),"Prompt Alert message not displayed as expected");
    	
    	
    }
}
