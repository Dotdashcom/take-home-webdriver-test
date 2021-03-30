package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {

    public WebDriver ldriver;

    public DynamicLoadingPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Start')]")
    WebElement btnStart;

    @FindBy(xpath = "//div[@id=\"finish\"]/h4")
    WebElement txtMessage;


    public void clkbtnStart() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(btnStart));
        wait.until(ExpectedConditions.elementToBeClickable(btnStart));
        btnStart.click();
    }

    public String gettxtMessage() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txtMessage));
        return txtMessage.getText();
    }
}
