package com.rural.rural.testcases;

import com.rural.rural.pages.ContextMenuPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContextMenuTest {
    private WebDriver driver;
    private ContextMenuPage contextMenuPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/context_menu");

        contextMenuPage = new ContextMenuPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void ContextMenuTest() {

        WebElement element = contextMenuPage.divHotSpot;
        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();

        // switch to the JavaScript alert and close it with the Enter key
        Alert alert = driver.switchTo().alert();
        //alert.sendKeys(Keys.RETURN);
        alert.accept();


        // close the browser
        driver.quit();

    }



}
