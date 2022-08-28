package com.project.pom.test;

import com.project.pom.page.DynamicControls;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.*;

public class DynamicControlsTest {

    private WebDriver driver;
    DynamicControls dynamicControls;

    @Before
    public void setUp(){
        dynamicControls = new DynamicControls(driver);
        driver = dynamicControls.chromeDriverConnection();
        dynamicControls.visit("/dynamic_controls");
    }

    @Test
    public void dynamicControlsTest() throws InterruptedException {

        By content = By.id("content");
        By removeButton = By.xpath("//form[@id='checkbox-example']/button[@type='button']");
        By waitForIt = By.xpath("//form[@id='checkbox-example']/div[@id='loading']");
        By message1 = By.id("message");
        By checkbox = By.xpath("//div[@id=\"checkbox\"]");
        By add = By.xpath("//*[@id=\"checkbox-example\"]//button[@type=\"button\"]");
        By againCheckbox = By.xpath("//input[@id=\"checkbox\"]");
        By enableButton = By.xpath("//form[@id='input-example']/button");
        By textBox = By.xpath("//form[@id='input-example']/input");
        By disable = By.xpath("//form[@id='input-example']/button");
        By messageDisable = By.xpath("//form[@id='input-example']/p[contains(text(),'disabled')]");

        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(15));
        if (driver.findElement(content).isDisplayed()){
            driver.findElement(removeButton).click();
            ewait.until(ExpectedConditions.invisibilityOfElementLocated(waitForIt));
            String gone = driver.findElement(message1).getText();
            assertEquals(gone,"It's gone!");
            driver.findElement(add).click();
            ewait.until(ExpectedConditions.visibilityOfElementLocated(againCheckbox));
            assertTrue(driver.findElement(againCheckbox).isDisplayed());
            driver.findElement(enableButton).click();
            ewait.until(ExpectedConditions.elementToBeClickable(textBox));
            assertTrue(driver.findElement(textBox).isEnabled());
            driver.findElement(disable).click();
            ewait.until(ExpectedConditions.visibilityOfElementLocated(messageDisable));
            assertFalse(driver.findElement(textBox).isEnabled());
        }else {
            System.out.println("Dynamic Controls page was not found");
        }
    }

    @After
    public void end(){ driver.quit(); }
}
