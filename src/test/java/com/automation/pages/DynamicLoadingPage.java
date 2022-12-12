package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage extends BasePage{


    @FindBy (xpath = "//a[@href='/dynamic_loading']")
    WebElement firstLink;

    @FindBy (xpath = "//a[@href='/dynamic_loading/2']")
    WebElement secondLink;

    @FindBy(xpath = "//div[@id='start'] /button")
    WebElement button;

    @FindBy(xpath = "//div[@id='finish']/h4")
    WebElement text;

    public void clickOnLink(){
        firstLink.click();
        secondLink.click();
    }
    public void waitUntilPresentText(){
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']/h4"), "Hello World!"));
        Assert.assertTrue(text.getText().contains("Hello World!"));

    }
}
