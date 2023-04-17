package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/windows
public class OpenNewTabPage {
    @FindBy(xpath = "//a[@href='/windows/new']")
    public WebElement linkClickHere;


    public OpenNewTabPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
