import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlertsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/javascript_alerts");
    }

    @Test
    public void testJSAlert() {
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("I am a JS Alert", alertMessage);
        alert.accept();
    }

    @Test
    public void testJSConfirm() {
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("I am a JS Confirm", alertMessage);
        alert.dismiss();
    }

    @Test
    public void testJSPrompt() {
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.sendKeys("Hello, World!");
        alert.accept();
        Assert.assertTrue(alertMessage.contains("Hello, World!"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
