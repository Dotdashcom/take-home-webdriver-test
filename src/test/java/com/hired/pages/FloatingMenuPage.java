package com.hired.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FloatingMenuPage {
    public WebDriver driver;

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="menu")
    public WebElement menu;

    public void floatingMenuValidation()  {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1800)");
        Assert.assertTrue(menu.isDisplayed());
    }
}
