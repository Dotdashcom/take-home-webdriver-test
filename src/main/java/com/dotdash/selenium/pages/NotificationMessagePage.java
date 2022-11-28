package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends BasePage {
    @FindBy(id="flash")
    WebElement messageBanner;

    @FindBy(css="a[href*=\"notification\"]")
    WebElement clickHereLink;

    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLink(){
        clickHereLink.click();
    }

    public String getMessageBanner(){
        return messageBanner.getText().split("×")[0].trim();
    }
}
