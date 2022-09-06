package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.JavaScriptAlertPage;
import pages.utils;

public class JavaScriptAlertTest {
    JavaScriptAlertPage javaScriptAlertPage;

    public JavaScriptAlertTest() {
        javaScriptAlertPage = new JavaScriptAlertPage();
    }

    @Test
    public void jsAlertTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/javascript_alerts");

        String expectedAlertMessage = "I am a JS Alert";
        String expectedConfirmMessage = "I am a JS Confirm";
        String userInput = "Test prompt alert";

        javaScriptAlertPage.clickAlertBtn();

        Alert alert = driver.switchTo().alert();
        String actualAlertMessage = alert.getText();
        alert.accept();

        try {
            Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
            System.out.println("passed");
        } catch (AssertionError e) {
            System.out.println("failed");
            throw e;
        }

        javaScriptAlertPage.clickConfirmBtn();

        String actualConfirmMessage = alert.getText();
        alert.accept();

        try {
            Assert.assertEquals(actualConfirmMessage, expectedConfirmMessage);
            System.out.println("passed");
        } catch (AssertionError e) {
            System.out.println("failed");
            throw e;
        }

        javaScriptAlertPage.clickPromptBtn();
        alert.sendKeys(userInput);
        alert.accept();
        String expectedPromptMessage = javaScriptAlertPage.getResultMessage();

        try {
            Assert.assertTrue(expectedPromptMessage.contains(userInput));
            System.out.println("passed");
        } catch (AssertionError e) {
            System.out.println("failed");
            throw e;
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



