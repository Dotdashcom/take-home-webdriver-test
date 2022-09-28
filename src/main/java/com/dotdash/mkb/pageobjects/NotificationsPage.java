package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NotificationsPage extends BasePage {

    @FindBy(css = "div#content > div.example > p > a")
    private WebElement clickHereLink;

    @FindBy(css = "div[class='flash notice']")
    private WebElement flashMessage;

    public NotificationsPage(WebDriver driver) {
        super(driver);
    }

    public void loadNewMessage() {
        clickHereLink.click();
    }

    public boolean isFlashMessageExpected() {
        return getFlashMessage().contains("Action unsuccesful, please try again") ||
                getFlashMessage().contains("Action successful") ||
                getFlashMessage().contains("Action unsuccessful");
    }

    private String getFlashMessage() {
        return flashMessage.getText();
    }
}
