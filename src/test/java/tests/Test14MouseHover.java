package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.LoginPage;
import pages.SecureAreaPage;

import java.util.ArrayList;
import java.util.List;

public class Test14MouseHover {
    WebDriver driver;

    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void Test14MouseHover() {
        String url = "http://localhost:7080/hovers";
        driver.get(url);

        By figureXpath = By.xpath("//div[@id='content']/descendant::div[@class='figure']");
        List<WebElement> figures = driver.findElements(figureXpath);

        String[] figureCaptionKeys = {
            "name: user1",
            "name: user2",
            "name: user3"
        };

        Assert.assertEquals(figureCaptionKeys.length,figures.size());

        Actions action = new Actions(driver);
        for(int i = 0; i < figures.size(); i++) {
            action.moveToElement(figures.get(i)).perform();
            String figureCaptionText = figures.get(i).findElement(By.xpath("descendant::h5")).getText();
            Assert.assertEquals(figureCaptionText,figureCaptionKeys[i]);
        }

    }

    @AfterMethod
    public void  tearDown() {
        driver.close();
    }
}