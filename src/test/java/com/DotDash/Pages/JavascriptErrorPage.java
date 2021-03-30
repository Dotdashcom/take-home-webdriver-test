package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavascriptErrorPage {

    public WebDriver ldriver;

    public JavascriptErrorPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//body/p")
    public WebElement txterror;

    public String gettxterror() {
        WebDriverWait wait = new WebDriverWait(ldriver, 25);
        wait.until(ExpectedConditions.visibilityOf(txterror));
        return txterror.getText();

    }


}
