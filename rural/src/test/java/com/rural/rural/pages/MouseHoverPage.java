package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/hovers
public class MouseHoverPage {
    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/img")
    public WebElement image1;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/img")
    public WebElement image2;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/img")
    public WebElement image3;

    @FindBy(xpath = "//*[text() = 'name: user1']")
    public WebElement name1;

    @FindBy(xpath = "//*[text() = 'name: user2']")
    public WebElement name2;

    @FindBy(xpath = "//*[text() = 'name: user3']")
    public WebElement name3;




    public MouseHoverPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
