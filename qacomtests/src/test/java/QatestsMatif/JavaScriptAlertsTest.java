package QatestsMatif;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browserUtil.Driver;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlertsTest {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(browserUtil.ConfigReader.get("baseUrl") + "/javascript_alerts");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

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
        alert.sendKeys("Hello Selenium :)");
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        alert.accept();

        WebElement resultTest = Driver.get().findElement(By.id("result"));
        String actualText = resultTest.getText();
        String expectedTest = "Hello Selenium :)";
        Assert.assertTrue(actualText.contains(expectedTest));


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}

