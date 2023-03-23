package shakilTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptErrorTest_16 {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testJavaScriptError() {
        driver.get("http://localhost:7080/javascript_error");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object onloadError = js.executeScript("return window.jsErrors");

        if (onloadError != null) {
            List<WebElement> errorMessages = driver.findElements(By.xpath("//body/p"));
            Assert.assertTrue(errorMessages.size() > 0, "Error message not displayed");
            System.out.println("Error message: " + errorMessages.get(0).getText());
        } else {
            Assert.fail("No JavaScript error detected on the page");
        }
    }
}
