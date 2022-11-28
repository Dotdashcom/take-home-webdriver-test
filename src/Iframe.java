import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframe {
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
        public void TestIframe() throws Exception {
            driver.get(baseUrl + "iframe");
            Thread.sleep(2000);
            // switch to iframe
            driver.switchTo().frame("mce_0_ifr");
            WebElement editable = driver.switchTo().activeElement();
            Thread.sleep(5000);
            // clear editor
            editable.clear();
            Thread.sleep(1000);
            // enter your text
            editable.sendKeys("Your text here......");
            Thread.sleep(2000);
            String text = editable.getText();
            Assert.assertEquals(text, "Your text here......");
        }

        @AfterTest
        public void tearDown() throws Exception {
           // driver.close();
            driver.quit();
        }

}