package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/floating_menu
public class FloatingMenuPage {
    @FindBy(xpath = "//a[@href='#home']")
    public WebElement linkHome;

    @FindBy(xpath = "//a[@href='#news']")
    public WebElement linkNews;

    @FindBy(xpath = "//a[@href='#contact']")
    public WebElement linkContact;

    @FindBy(xpath = "//a[@href='#about']")
    public WebElement linkAbout;




    public FloatingMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
