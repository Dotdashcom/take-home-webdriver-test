package JavaScriptAlertPack;
import Main.Package.JavaScriptAlertsPage;
import bsh.util.JConsole;
import org.asynchttpclient.util.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlertsPageTest {
    private WebDriver driver;
    private JavaScriptAlertsPage javaScriptAlertsPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/javascript_alerts");
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
    }

    @Test
    public void JavaScriptAlertButton1() {

        WebElement JSAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        WebElement JSButtonConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        WebElement JSButtonPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));

try {

            JSAlertButton.click();
        Thread.sleep(4000);
    Alert alert = driver.switchTo().alert();
    String alertText = alert.getText();
    String expectedAlertText = "I am a JS Alert";
    System.out.println(alertText);
    Assert.assertEquals("I am a JS Alert", alertText);

            driver.switchTo().alert().accept();

     } catch (Exception e) {
        System.out.println(e);
    }

}
@Test

    public void ConfirmButtonTest() {


    WebElement JSAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
    WebElement JSButtonConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
    WebElement JSButtonPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));

    try {

        JSButtonConfirm.click();
        Thread.sleep(4000);
        Alert alert1 = driver.switchTo().alert();
        String alertText1 = alert1.getText();
        String expectedAlertText = "I am a JS Confirm";
        System.out.println(alertText1);
        Assert.assertEquals("I am a JS Confirm", alertText1);

        driver.switchTo().alert().accept();

    } catch (Exception e) {
        System.out.println(e);
    }

}
@Test

    public void JSPromptTest() {

    WebElement JSAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
    WebElement JSButtonConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
    WebElement JSButtonPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
WebElement ResultMessage = driver.findElement(By.xpath("//p[@id='result']"));

    try {

        JSButtonPrompt.click();
        Thread.sleep(3000);
        Alert alert1 = driver.switchTo().alert();
        driver.switchTo().alert().sendKeys("Hey I'm Andre");


        driver.switchTo().alert().accept();
        String ResultText = ResultMessage.getText();
        System.out.println(ResultText);
        Assert.assertEquals("You entered: Hey I'm Andre", ResultText);

    } catch (Exception e) {
        System.out.println(e);
    }

}
    @After
    public void TearDown() {
        driver.quit();
    }
}




