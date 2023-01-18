package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotificationMessagePage extends BasePage {

    // PAGE INITIALIZATION:
    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By CLICK_HERE = By.xpath("//a[contains(text(),'Click here')]");
    private static final By MESSAGE_TXT = By.id("flash");

    // WEB ELEMENTS:
    private WebElement getClickHere() {
        wait.until(ExpectedConditions.elementToBeClickable(CLICK_HERE));
        return driver.findElement(CLICK_HERE);
    }

    private WebElement getMessageTxt() {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_TXT));
        return driver.findElement(MESSAGE_TXT);
    }

    // METHODS:
    public void clickOnTheLink() {
        log.info("User clicks on the 'Click Here' link. ");
        getClickHere().click();
    }

    public boolean someMsgDisplayed(String[] array, int times) {
        boolean flag = false;
        String[] alertList = new String[times];
        for (int i = 0; i < times; i++) {
            alertList[i] = getMessageTxt().getText();
            clickOnTheLink();
        }
        for (String msg : array) {
            for (String alert : alertList) {
                if (alert.contains(msg)) {
                    log.warn("Msg appears '" + msg + "'. ");
                    flag = flag || alert.contains(msg);
                }
            }
        }
        return flag;
    }

}


