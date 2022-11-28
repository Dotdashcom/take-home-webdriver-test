import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContextMenu {

        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();


        @BeforeTest
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver","BrowserWebDrivers\\chromedriver.exe");

            driver = new ChromeDriver();
            baseUrl = "http://localhost:7080/";
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        }

        @Test
        public void TestContext() throws Exception {
            driver.get(baseUrl + "context_menu");
            // context click on the element
            WebElement container = driver.findElement(By.id("hot-spot"));
            Actions actions = new Actions(driver);
            actions.contextClick(container).perform();
            Thread.sleep(2000);

            //Alert Message (Expected Text)
            String expectedAlertMessage = "You selected a context menu";
            // Alert Text (Actual Text)
            String actualAlertMessage = driver.switchTo().alert().getText();
            Thread.sleep(1000);

            //Assertion
            Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
            Thread.sleep(1000);

            //Accept the alert (Click OK)
            driver.switchTo().alert().accept();
        }

        @AfterTest
        public void tearDown() throws Exception {
           // driver.close();
            driver.quit();
        }

}