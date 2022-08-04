package tests;

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

public class Test11FileUpload {
    WebDriver driver;

    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void Test11FileUpload() throws InterruptedException {
        String url = "http://localhost:7080/upload";
        String filePath = "/Users/" + System.getProperty("user.name") + "/Downloads/some-file.txt";
        driver.get(url);

        By uploadInputXpath = By.xpath("//input[@id='file-upload']");
        By uploadButtonXpath = By.xpath("//input[@class='button']");
        By uploadedLabelXpath = By.xpath("//div[@id='uploaded-files']");
        driver.findElement(uploadInputXpath).sendKeys(filePath);
        driver.findElement(uploadButtonXpath).click();
        Assert.assertTrue(driver.findElement(uploadedLabelXpath).isDisplayed());
    }

    @AfterMethod
    public void  tearDown() {
        driver.close();
    }
}