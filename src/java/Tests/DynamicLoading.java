package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverUtilities;

import java.time.Duration;

public class DynamicLoading extends DriverUtilities {
    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/dynamic_loading/2");
    }
    @Test
    public void dynamicLoading(){
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement pageTitle = driver.findElement(By.xpath("//h3[contains(text(),'Dynamically Loaded Page')]"));
        Assert.assertTrue("User is not on Dynamically Loaded Page", pageTitle.isDisplayed());

        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));

        Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText(), "Hello World!");
    }
    @After
    public void cleanUp() {
        quitDriver();
    }
}


