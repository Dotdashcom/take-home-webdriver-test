package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;

public class JavaScriptAlertsTest extends DriverUtilities {
    @Before
    public void setUp() {
        createDriver();
        getDriver().navigate().to("http://localhost:7080/javascript_alerts");
    }
    @Test
    public void jsAlerts(){
        WebDriver driver = getDriver();
        WebElement pageTitle = driver.findElement(By.xpath("//h3[contains(text(),'JavaScript Alerts')]"));
        Assert.assertTrue("User is not on JavaScript Alerts page", pageTitle.isDisplayed());


        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Alert a = driver.switchTo().alert();
        String alertMessage1 = a.getText();
        Assert.assertEquals(alertMessage1, "I am a JS Alert");
        a.accept();


        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        Alert b = driver.switchTo().alert();
        String alertMessage2 = b.getText();
        Assert.assertEquals(alertMessage2, "I am a JS Confirm");
        b.accept();


        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        Alert c = driver.switchTo().alert();
        c.sendKeys("Hello!");
        c.accept();
        String resultText = driver.findElement(By.xpath("/html//p[@id='result']")).getText();
        Assert.assertEquals(resultText, "You entered: Hello!");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }
}


