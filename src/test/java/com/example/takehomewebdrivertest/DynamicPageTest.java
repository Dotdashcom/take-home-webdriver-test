package com.example.takehomewebdrivertest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPageTest {
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
    public void dynamicContent() throws InterruptedException {
        driver.get(BaseUrl + "dynamic_content");
        String[] initialContents = getContents(driver);
        // Refresh 3 times
        for (int i = 0; i < 3; i++) {
            driver.navigate().refresh();
            //Wait for page update
            Thread.sleep(1000);
            String[] newContents = getContents(driver);
            Assertions.assertFalse(initialContents == newContents);
            initialContents = newContents;
        }
    }

    //Helper method for dynamicContent method
    private static String[] getContents(WebDriver driver) {
        //number of contents
        int contentNum = 3;
        String[] contents = new String[contentNum];
        for (int i = 1; i <= contentNum; i++) {
            String path = String.format("//*[@id='content']/div[%d]/div[2]", i);
            contents[i - 1] = driver.findElement(By.xpath(path)).getText();
        }
        return contents;
    }

    @Test
    public void DynamicControlsCheckbox() {
        driver.get(BaseUrl + "dynamic_controls");
        WebElement buttonCheckbox = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Explicit wait for checkbox gone
        buttonCheckbox.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        //Explicit wait for checkbox is present
        buttonCheckbox.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
        Assertions.assertTrue(driver.findElement(By.id("checkbox")).isDisplayed());
    }

    @Test
    public void DynamicControlsInput() {
        driver.get(BaseUrl + "dynamic_controls");
        WebElement buttonInput = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        WebElement input = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Explicit wait for input is enabled
        buttonInput.click();
        wait.until(ExpectedConditions.elementToBeClickable(input));
        Assertions.assertTrue(input.isEnabled());
        //Explicit wait for input is disabled
        buttonInput.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(input)));
        Assertions.assertFalse(input.isEnabled());
    }

    @Test
    public void dynamicLoading() {
        driver.get(BaseUrl + "dynamic_loading/2");
        WebElement startButton = driver.findElement(By.xpath("//*[@id='start']/button"));
        startButton.click();
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assert (driver.findElement(By.id("finish")).getText().equals("Hello World!"));
    }
}
