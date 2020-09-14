package testByGeorgKelava;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlert {
    public JavaScriptAlert() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "javascript_alerts");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }



    @Test
    public void AlertTest() {
        WebElement JSAlertButton = Driver.get().findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]"));
        JSAlertButton.click();
        Alert alert = Driver.get().switchTo().alert();
        String actualAlertTxt = alert.getText();
        String expectedAlertTxt = "I am a JS Alert";
        Assert.assertEquals(expectedAlertTxt, actualAlertTxt);
    }

    @Test
    public void ConfirmTest() {
        WebElement JSConfirmButton = Driver.get().findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]"));
        JSConfirmButton.click();
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
        WebElement visibleTxt = Driver.get().findElement(By.xpath("//p[@id=\"result\"][contains(text(), 'You clicked: Ok')]"));
        Assert.assertTrue(visibleTxt.isDisplayed());
    }

    @Test
    public void PromptTest() {
        WebElement JSPromptButton = Driver.get().findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]"));
        JSPromptButton.click();
        Alert alert = Driver.get().switchTo().alert();
        alert.sendKeys("promptTest");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        alert.accept();
        WebElement resultTest = Driver.get().findElement(By.id("result"));
        String actualText = resultTest.getText();
        String expectedTest = "promptTest";
        Assert.assertTrue(actualText.contains(expectedTest));
    }
}
