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

public class DynamicControls extends DriverUtilities {
    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/dynamic_controls");
    }
    @Test
    public void dynamicControls(){
        WebDriver driver = getDriver();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement pageTitle = driver.findElement(By.xpath("//h4[contains(text(),'Dynamic')]"));
        Assert.assertTrue("User is not on Dynamic Controls page", pageTitle.isDisplayed());

        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();
        WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
        Assert.assertTrue(until.getText().contains("gone"));

        WebElement dynamicControlsAdd = driver.findElement(By.xpath("//button[text()='Add']"));
        dynamicControlsAdd.click();
        until = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
        Assert.assertTrue(until.getText().contains("back"));

        WebElement dynamicControlsEnable = driver.findElement(By.xpath("//button[text()='Enable']"));
        dynamicControlsEnable.click();
        until = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
        Assert.assertTrue(until.getText().contains("enabled"));

        WebElement dynamicControlsDisable = driver.findElement(By.xpath("//button[text()='Disable']"));
        dynamicControlsDisable.click();
        until = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
        Assert.assertTrue(until.getText().contains("disabled"));

    }
    @After
    public void cleanUp() {
        quitDriver();
    }
}


