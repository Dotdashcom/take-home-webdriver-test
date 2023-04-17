package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/upload
public class NotificationMessagePage {


    @FindBy(xpath = "//a[@href='/notification_message']")
    public WebElement linkClickHere;

    @FindBy(id = "flash")
    public WebElement divFlash;



    public NotificationMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
