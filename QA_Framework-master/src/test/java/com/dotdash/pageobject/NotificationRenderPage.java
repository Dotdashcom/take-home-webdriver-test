package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class NotificationRenderPage extends BasePageObject {
    private By hyperlink = By.linkText("Click Here");
    private By UnsuccessfulMsg = By.xpath("//*[contains(text(),'Action unsuccesful, please try again')]");
    private By Msg = By.xpath("//*[@id=\"flash\"]");
    private final String UnsuccessfulMsg1 = "Action unsuccesful, please try again";
    private final String SuccessfulMsg1 = "Action successful";


    public NotificationRenderPage(WebDriver driver) {
        this.driver = driver;
        open_page("windows");
    }

    public void verifynotificationpage() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            driver.findElement(hyperlink).click();
            Thread.sleep(1000);
            String actual_displayed = driver.findElement(Msg).getText();
            if (driver.findElement(UnsuccessfulMsg).isDisplayed()) {
                Assert.assertEquals(actual_displayed, UnsuccessfulMsg1, "Action unsuccesful, please try again");
            }
            else {
                Assert.assertEquals(actual_displayed, SuccessfulMsg1, "Action successful");
            }
        }
    }
}