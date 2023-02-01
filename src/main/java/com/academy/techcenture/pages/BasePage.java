package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

import static com.academy.techcenture.configReader.ConfigReader.getProperty;

public class BasePage {

    protected WebDriver driver;

    protected SoftAssert softAssert;

    public BasePage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String pageName){
        driver.get( (getProperty("url")) + pageName);
    }

    protected void btnClick(WebElement btn){
        softAssert.assertTrue(btn.isEnabled(), "Button " + btn.getClass().getTypeName() + " is not click");
        btn.click();
    }

    protected void verifyWebElementIsGone(WebElement block){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(block)));
        softAssert.assertFalse(block.isDisplayed(), block.getClass().getPackage().getName() + " is still displayed"); // how add matches name?
    }

}
