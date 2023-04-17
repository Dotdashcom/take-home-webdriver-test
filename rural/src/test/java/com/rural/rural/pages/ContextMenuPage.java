package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/context_menu
public class ContextMenuPage {

    @FindBy(xpath = "//*[@id='hot-spot']")
    public WebElement divHotSpot;


    public ContextMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
