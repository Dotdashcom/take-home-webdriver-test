import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class NotificationMessage {

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
        public void TestSuccess() throws Exception {
            driver.get(baseUrl + "notification_message_rendered");
            Thread.sleep(2000);
            driver.findElement(By.linkText("Click here")).click();
            Thread.sleep(2000);
            String expectedMessage = "Action successful";
            String actualMessage = driver.findElement(By.className("notice")).getText().replace("×", "");
            Assert.assertEquals(actualMessage.trim(), expectedMessage);

        }

        @Test(priority = 1)
        public void TestUnsuccessful() throws Exception {
            driver.get(baseUrl + "notification_message_rendered");
            Thread.sleep(2000);
            driver.findElement(By.linkText("Click here")).click();
            Thread.sleep(2000);
            String expectMessage = "Action unsuccesful, please try again";
            String actualMessage = driver.findElement(By.id("flash-messages")).getText().replace("×", "");
            Assert.assertEquals(actualMessage.trim(), expectMessage);

        }



        @AfterTest
        public void tearDown() throws Exception {
           // driver.close();
            driver.quit();
        }

}