package MarionelaTirsina;

;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlerts {
    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl") + "/javascript_alerts");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }

    //    JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
    @Test
    public void alertTest() {
        WebElement JSAlertButton = Driver.getDriver().findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]"));
        JSAlertButton.click();

        Alert alert = Driver.getDriver().switchTo().alert();
        String actAlertText = alert.getText();
        String expAlertText = "I am a JS Alert";

        Assert.assertEquals(expAlertText, actAlertText);
    }

    @Test
    public void JSConfirmTest() {
        WebElement JSConfirmButton = Driver.getDriver().findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]"));
        JSConfirmButton.click();

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        WebElement visibleText = Driver.getDriver().
                findElement(By.xpath("//p[@id=\"result\"][contains(text(), 'You clicked: Ok')]"));

        Assert.assertTrue(visibleText.isDisplayed());
    }

    @Test
    public void JSPromptTest() {
        WebElement JSPromptButton = Driver.getDriver().findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]"));
        JSPromptButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("Hello! This is Metin Kaya....");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        alert.accept();

        WebElement resultTest = Driver.getDriver().findElement(By.id("result"));
        String actualText = resultTest.getText();
        String expectedTest = "Hello! This is Metin Kaya...";
        Assert.assertTrue(actualText.contains(expectedTest));


    }
}

