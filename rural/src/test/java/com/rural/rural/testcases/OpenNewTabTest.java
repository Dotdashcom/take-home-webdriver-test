package com.rural.rural.testcases;


import com.rural.rural.pages.OpenNewTabPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class OpenNewTabTest {
    private WebDriver driver;
    private OpenNewTabPage openNewTabPage;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:7080/windows");

        openNewTabPage = new OpenNewTabPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test()
    public void OpenNewTab() throws InterruptedException {

        openNewTabPage.linkClickHere.click();
        // Get all the open window handles
        Set<String> handles = driver.getWindowHandles();

        // Switch to the new tab
        for(String handle: handles){
            driver.switchTo().window(handle);
        }

        // Verify the URL of the new tab
        String url = driver.getCurrentUrl();
        assertEquals("http://localhost:7080/windows/new", url);

        // close the browser
        driver.quit();

    }



}
