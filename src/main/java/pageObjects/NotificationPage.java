package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationPage extends Base {
    WebDriver driver;

    By hereLink = By.xpath(readValue("notificationPage.clickHereLinkXp"));
    By messageAlert = By.xpath(readValue("notificationPage.messageAlertXp"));

    public void clickHereLink() {
        driver.findElement(hereLink).click();
    }

    public boolean isAnyMessageDisplayed(String[] messages) {
        boolean matchFound = false;
        String[] alerts = new String[10];
        //click 10 times the link and store messages in an array
        for (int i = 0; i < 10; i++) {
            alerts[i] = driver.findElement(messageAlert).getText();
            clickHereLink();
        }
        for (String message : messages) {
            for (String alert : alerts) {
                if (alert.contains(message)) {
                    matchFound = matchFound || alert.contains(message);
                }
            }
        }
        return matchFound;
    }

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
    }
}
