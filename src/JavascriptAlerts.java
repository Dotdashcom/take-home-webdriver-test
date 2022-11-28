import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavascriptAlerts {
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

        @Test(priority = 0)
        public void TestJSAlert() throws Exception {
            driver.get(baseUrl + "javascript_alerts");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
            Thread.sleep(2000);
            //Alert Message (Expected Text)
            String expectedAlertMessage = "I am a JS Alert";
            // Alert Text (Actual Text)
            String actualAlertMessage = driver.switchTo().alert().getText();
            Thread.sleep(1000);
            //Assertion
            Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
            Thread.sleep(1000);
            // click OK to close
            driver.switchTo().alert().accept();

        }

        @Test(priority = 1)
        public void TestJSConfirm() throws Exception {
            driver.get(baseUrl + "javascript_alerts");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
            Thread.sleep(2000);
            //Alert Message (Expected Text)
            String expectedConfirmMessage = "I am a JS Confirm";
            // Alert Text (Actual Text)
            String actualConfirmMessage = driver.switchTo().alert().getText();
            Thread.sleep(1000);
            //Assertion
            Assert.assertEquals(expectedConfirmMessage, actualConfirmMessage);
            Thread.sleep(1000);
            driver.switchTo().alert().accept();

        }

        @Test(priority = 2)
        public void TestJSPrompt() throws Exception {
            driver.get(baseUrl + "javascript_alerts");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
            Thread.sleep(2000);
            String expectedResult = "This is a JS prompt";
            driver.switchTo().alert().sendKeys(expectedResult);
            Thread.sleep(1000);
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
            String result = driver.findElement(By.id("result")).getText();
            String actualResult = result.replace("You entered: ","");
            Assert.assertEquals(expectedResult, actualResult);

        }

        @AfterTest
        public void tearDown() throws Exception {
           // driver.close();
            driver.quit();
        }

}