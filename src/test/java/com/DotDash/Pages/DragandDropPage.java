package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DragandDropPage {

    public WebDriver ldriver;
    @FindBy(xpath = "//*[@id=\"column-a\"]")
    public WebElement boxColumnA;
    @FindBy(xpath = "//*[@id=\"column-b\"]")
    public WebElement boxColumnB;
    @FindBy(xpath = "//div[@id='column-a']/header")
    public WebElement headerA;
    @FindBy(xpath = "//div[@id='column-b']/header")
    public WebElement headerB;

    public DragandDropPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public String getheaderA() {
        return headerA.getText();
    }

    public String getheaderB() {
        return headerB.getText();
    }
}