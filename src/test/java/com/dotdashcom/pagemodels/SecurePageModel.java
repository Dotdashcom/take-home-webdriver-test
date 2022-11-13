package com.dotdashcom.pagemodels;

import com.dotdashcom.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePageModel extends PageObject {

    public static final String PAGE_URL = "/secure";
    public static final String LOGIN_SUCCESSFUL_MESSAGE = "You logged into a secure area!";

    @FindBy(id = "flash")
    private WebElement message;

    public SecurePageModel(WebDriver driver) {
        super(driver);
    }

    public String getMessageText() {
        return message.getText();
    }

}
