package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage {
    public WebDriver driver;
    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@id='start']/button")
    public WebElement startButton;

    @FindBy(xpath = "//h4[normalize-space()='Hello World!']")
    public WebElement helloWorldMsg;

    public void verifyMessage()  {
        startButton.click();
        WebDriverWait wait =new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(helloWorldMsg));
        Assert.assertTrue(helloWorldMsg.isDisplayed());
    }


}
