package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenWindowPage {

    public WebDriver ldriver;

    public OpenWindowPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Click Here')]")
    WebElement btnClickhere;

    @FindBy(xpath = "//h3[contains(text(),'New Window')]")
    WebElement txtNewWindow;


    public void setBtnClickhere() {
        btnClickhere.click();
    }

    public boolean gettxtNewWindow() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txtNewWindow));
        if (txtNewWindow.getText().equals("New Window")) {
            return true;
        } else {
            return false;
        }
    }


}
