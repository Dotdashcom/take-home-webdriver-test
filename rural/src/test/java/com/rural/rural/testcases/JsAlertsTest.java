package com.rural.rural.testcases;


import com.rural.rural.pages.JsAlertsPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class JsAlertsTest {
    private WebDriver driver;
    private JsAlertsPage jsAlertsPage;



    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/javascript_alerts");

        jsAlertsPage = new JsAlertsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void JsAlert() throws InterruptedException {

        jsAlertsPage.buttonClickForAlert.click();

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Close the alert by accepting it
        alert.accept();

        Thread.sleep(500);

        Assert.assertTrue(jsAlertsPage.Result.getText().equals("You successfuly clicked an alert"));



        // Switch back to the main content of the webpage
        driver.switchTo().defaultContent();

        jsAlertsPage.buttonClickForConfirm.click();

        // Switch to the alert
        alert = driver.switchTo().alert();

        Thread.sleep(500);

        alert.accept();

        Assert.assertTrue(jsAlertsPage.Result.getText().equals("You clicked: Ok"));

        // Switch back to the main content of the webpage
        driver.switchTo().defaultContent();

        jsAlertsPage.buttonClickFor.click();

        // Switch to the alert
        alert = driver.switchTo().alert();

        alert.sendKeys("aaa");

        alert.accept();

        Assert.assertTrue(jsAlertsPage.Result.getText().equals("You entered: aaa"));

        Thread.sleep(500);

        //Assert.assertTrue(jsAlertsPage.Result.getText().equals("You entered: null"));


        // close the browser
        driver.quit();

    }



}
