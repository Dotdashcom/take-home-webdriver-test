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

public class Test13Iframe {
    WebDriver driver;

    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void Test13Iframe() throws InterruptedException {
        String url = "http://localhost:7080/iframe";
        driver.get(url);

        //switch to the iframe and set the text of the textarea
        driver.switchTo().frame("mce_0_ifr");
        WebElement textArea = driver.findElement(By.xpath("//body"));
        textArea.clear();
        textArea.sendKeys("Hello World!");

        //assert that the text is what was typed in previously
        Assert.assertEquals(driver.findElement(By.xpath("//body/p")).getText(),"Hello World!");

    }

    @AfterMethod
    public void  tearDown() {
        driver.close();
    }
}