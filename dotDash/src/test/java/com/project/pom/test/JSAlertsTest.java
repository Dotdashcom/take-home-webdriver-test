package com.project.pom.test;

import com.project.pom.page.JSAlerts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class JSAlertsTest {

    private WebDriver driver;
    JSAlerts jsAlerts;

    @Before
    public void setUp(){
        jsAlerts = new JSAlerts(driver);
        driver = jsAlerts.chromeDriverConnection();
        jsAlerts.visit("/javascript_alerts");
    }

    @Test
    public void jsAlertsTest(){

        By alert = By.xpath("//*[@class='example']/ul/li/button[text()='Click for JS Alert']");
        By confirm = By.xpath("//*[@class='example']/ul/li/button[text()='Click for JS Confirm']");
        By prompt = By.xpath("//*[@class='example']/ul/li/button[text()='Click for JS Prompt']");
        By result = By.xpath("//div[@class='example']/p[@id='result']");
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(15));

        jsAlerts.click(alert);
        Alert alertMessage = ewait.until(ExpectedConditions.alertIsPresent());
        assertEquals(alertMessage.getText(),"I am a JS Alert");
        alertMessage.accept();

        jsAlerts.click(confirm);
        alertMessage = ewait.until(ExpectedConditions.alertIsPresent());
        assertEquals(alertMessage.getText(),"I am a JS Confirm");
        alertMessage.accept();

        jsAlerts.click(prompt);
        alertMessage = ewait.until(ExpectedConditions.alertIsPresent());
        alertMessage.sendKeys("Message");
        alertMessage.accept();
        assertEquals("You entered: Message", jsAlerts.getText(result));
    }

    @After
    public void end(){ driver.quit(); }
}
