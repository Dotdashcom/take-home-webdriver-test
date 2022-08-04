package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.LoginPage;
import pages.SecureAreaPage;

public class Test12FloatingMenu {
    WebDriver driver;

    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void Test12FloatingMenu() throws InterruptedException {
        String url = "http://localhost:7080/floating_menu";
        driver.get(url);

        By floatingMenuXpath = By.xpath("//div[@class='example']/descendant::div[@id='menu']");
        Assert.assertTrue(driver.findElement(floatingMenuXpath).isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Assert.assertTrue(driver.findElement(floatingMenuXpath).isDisplayed());

    }

    @AfterMethod
    public void  tearDown() {
        driver.close();
    }
}