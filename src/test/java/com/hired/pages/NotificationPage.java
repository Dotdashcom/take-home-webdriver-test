package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NotificationPage {
    public WebDriver driver;
    public NotificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//p/a")
    public WebElement clickHere;

    @FindBy(id="flash")
    public WebElement flashMessage;

    public void verifyNotification(String expectedMessage1, String expectedMessage2) {
        String actualMessage1 = null;
        String actualMessage2 = null;
        do {
            clickHere.click();
            String flashMessageText = flashMessage.getText();
            if (flashMessageText.startsWith(expectedMessage1)) {
                actualMessage1 = flashMessageText.substring(0, 17);
            } else if (flashMessageText.startsWith(expectedMessage2)) {
                actualMessage2 = flashMessageText.substring(0, 36);

            }
        } while (actualMessage1 == null || actualMessage2 == null);
        Assert.assertEquals(actualMessage1, expectedMessage1);
        Assert.assertEquals(actualMessage2, expectedMessage2);
    }
}
