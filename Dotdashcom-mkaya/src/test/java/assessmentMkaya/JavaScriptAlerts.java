package assessmentMkaya;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlerts {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/javascript_alerts");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }

    //    JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
    @Test
    public void alertTest() {
        WebElement JSAlertButton = Driver.get().findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]"));
        JSAlertButton.click();

        Alert alert = Driver.get().switchTo().alert();
        String actAlertText = alert.getText();
        String expAlertText = "I am a JS Alert";

        Assert.assertEquals(expAlertText, actAlertText);
    }

    @Test
    public void JSConfirmTest() {
        WebElement JSConfirmButton = Driver.get().findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]"));
        JSConfirmButton.click();

        Alert alert = Driver.get().switchTo().alert();
        alert.accept();

        WebElement visibleText = Driver.get().
                findElement(By.xpath("//p[@id=\"result\"][contains(text(), 'You clicked: Ok')]"));

        Assert.assertTrue(visibleText.isDisplayed());
    }

    @Test
    public void JSPromptTest() {
        WebElement JSPromptButton = Driver.get().findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]"));
        JSPromptButton.click();
        Alert alert = Driver.get().switchTo().alert();
        alert.sendKeys("Hello! This is Metin Kaya....");
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        alert.accept();

        WebElement resultTest = Driver.get().findElement(By.id("result"));
        String actualText = resultTest.getText();
        String expectedTest = "Hello! This is Metin Kaya...";
        Assert.assertTrue(actualText.contains(expectedTest));


    }
}

