package com.example.takehomewebdrivertest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.time.Duration;
import java.util.List;

public class JavaScriptAlertTest {
    private WebDriver driver;
    private static final String BaseUrl = "http://localhost:7080/";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void jsAlert() {
        driver.get(BaseUrl + "javascript_alerts");
        WebElement button = driver.findElement(By
                .xpath("//*[@id='content']/div/ul/li[1]/button"));
        button.click();
        // Switch to the alert dialog
        Alert alert = driver.switchTo().alert();
        //Validate message
        assert (alert.getText().equals("I am a JS Alert"));
    }

    @Test
    public void jsConfirm() {
        driver.get(BaseUrl + "javascript_alerts");
        WebElement button = driver.findElement(By
                .xpath("//*[@id='content']/div/ul/li[2]/button"));
        button.click();
        // Switch to the alert dialog
        Alert alert = driver.switchTo().alert();
        //Validate message
        assert (alert.getText().equals("I am a JS Confirm"));
    }

    @Test
    public void jsPrompt() {
        driver.get(BaseUrl + "javascript_alerts");
        WebElement button = driver.findElement(By
                .xpath("//*[@id='content']/div/ul/li[3]/button"));
        button.click();
        // Switch to the alert dialog
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("test");
        alert.accept();
        //Validate message
        assert (driver.findElement(By.id("result")).getText().equals("You entered: test"));
    }
    @Test
    public void jsError() {
        driver.get(BaseUrl + "javascript_error");
        // Execute JavaScript to check for errors
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // to obtain browser errors
        List<LogEntry> lg = driver.manage().logs().get(LogType.BROWSER).getAll();
        Assertions.assertTrue(lg.get(0).toString()
                .contains("Cannot read properties of undefined (reading 'xyz')"));
    }
}
