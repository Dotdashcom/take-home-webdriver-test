package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JS_AlertPage {

    public WebDriver driver;
    public JS_AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//ul/li[1]/button")
    public WebElement alertButton;

    @FindBy(xpath="//ul/li[2]/button")
    public WebElement confirmButton;

    @FindBy(xpath="//ul/li[3]/button")
    public WebElement promptButton;

    @FindBy(xpath = "//*[@id='result']")
    public WebElement alertMessage;

    public void clickOnAlert()  {
        alertButton.click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Alert");
        driver.switchTo().alert().accept();
    }

    public void clickOnConfirm()  {
        confirmButton.click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Confirm");
        driver.switchTo().alert().accept();
    }

    public void clickOnPrompt(String message) {
        promptButton.click();
        driver.switchTo().alert().sendKeys(message);
        driver.switchTo().alert().accept();
        Assert.assertTrue(alertMessage.getText().contains(message));
    }
}
