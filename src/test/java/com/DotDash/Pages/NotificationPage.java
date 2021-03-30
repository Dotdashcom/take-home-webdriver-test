package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationPage {

    public WebDriver ldriver;

    public NotificationPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Click here')]")
    WebElement lnkClickhere;

    @FindBy(xpath = "//div[@id='flash']")
    WebElement txtnotification;


    public void clklnkClickhere() {
        lnkClickhere.click();
    }

    public String gettxtnotification() {
        WebDriverWait wait = new WebDriverWait(ldriver, 40);
        wait.until(ExpectedConditions.visibilityOf(txtnotification));
        return txtnotification.getText();
    }


}
