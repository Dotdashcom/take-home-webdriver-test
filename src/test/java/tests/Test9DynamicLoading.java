package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.LoginPage;
import pages.SecureAreaPage;

public class Test9DynamicLoading {
    WebDriver driver;

    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void Test9DynamicLoading() {
        String url = "http://localhost:7080/dynamic_loading/2";
        driver.get(url);

        By startButtonXpath = By.xpath("//div[@id='start']/button");
        By loadingBarXpath = By.xpath("//div[@id='loading']");
        By finishedTitleXpath = By.xpath("//div[@id='finish']/h4");

        WebDriverWait wait = new WebDriverWait(driver,15);

        WebElement startButton = driver.findElement(startButtonXpath);
        startButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBarXpath));
        WebElement finishedTitle = driver.findElement(finishedTitleXpath);
        Assert.assertTrue(finishedTitle.isDisplayed());
    }

    @AfterMethod
    public void  tearDown() {
        driver.close();
    }
}