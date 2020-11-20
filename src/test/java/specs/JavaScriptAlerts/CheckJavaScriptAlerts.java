package specs.JavaScriptAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import specs.AbstractSpec;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #15 JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert
public class CheckJavaScriptAlerts extends AbstractSpec {
    private static final long DEFAULT_PAUSE = 2000;
    private static By byJSAlert = By.xpath("//button[text()='Click for JS Alert']");
    private static By byJSConfirm = By.xpath("//button[text()='Click for JS Confirm']");
    private static By byResult = By.id("result");
    private static By byJSPrompt = By.xpath("//button[text()='Click for JS Prompt']");

    @BeforeTest
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/javascript_alerts");
    }

    @Test(priority = 1, enabled = true)
    public void checkJavaScriptAlert() throws Exception {
        SoftAssert softas = new SoftAssert();

        driver.findElement(byJSAlert).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(DEFAULT_PAUSE);

        // Validate Alert message
        softas.assertTrue(alert.getText().equals("I am a JS Alert"),
                "Alert message doesn't match to expected");

        alert.accept();
        Thread.sleep(DEFAULT_PAUSE);

        softas.assertAll();
    }

    @Test(priority = 2, enabled = true)
    public void checkJavaScriptConfirm() throws Exception {
        SoftAssert softas = new SoftAssert();

        driver.findElement(byJSConfirm).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(DEFAULT_PAUSE);

        alert.accept();
        Thread.sleep(DEFAULT_PAUSE);

        // Validate Result message
        softas.assertTrue(driver.findElement(byResult).getText().equals("You clicked: Ok"),
                "Result message doesn't match to expected");

        softas.assertAll();
    }

    @Test(priority = 3, enabled = true)
    public void checkJavaScriptPrompt() throws Exception {
        SoftAssert softas = new SoftAssert();
        String expPrompt = "Hello World!";

        driver.findElement(byJSPrompt).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(DEFAULT_PAUSE);

        alert.sendKeys(expPrompt);

        alert.accept();
        Thread.sleep(DEFAULT_PAUSE);

        String actPrompt = driver.findElement(byResult).getText();

        // Validate Result message
        softas.assertTrue(actPrompt.contains(expPrompt),
                "Result message doesn't match to expected");

        softas.assertAll();
    }

}
