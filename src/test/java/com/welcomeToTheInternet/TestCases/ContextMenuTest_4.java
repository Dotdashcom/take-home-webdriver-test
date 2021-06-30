package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.ContextMenuPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContextMenuTest_4 extends BaseClass {

    @Test
    public void ContextMenuTest() throws IOException {
        driver.get(baseURL);
        ContextMenuPage contextMenu = new ContextMenuPage(driver);

        contextMenu.clickContextMenuLink();
        logger.info("Navigated to Context Menu page");
        contextMenu.clickOnBox();
        logger.info("Clicked to the element");
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();

        boolean isAlertMessage = message.contains("You selected a context menu");
        if (isAlertMessage) {
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "Failed get the alert message");
        }
        alert.accept();
    }
}
