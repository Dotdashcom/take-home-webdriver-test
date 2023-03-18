package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextPage {
    public WebDriver driver;
    public ContextPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="hot-spot")
    public WebElement context;


}
