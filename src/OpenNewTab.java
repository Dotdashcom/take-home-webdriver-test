import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenNewTab {

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
        public void TestNewTab() throws Exception {
            driver.get(baseUrl + "windows");
            Thread.sleep(2000);
            driver.findElement(By.linkText("Click Here")).click();
            Thread.sleep(2000);
            Object[] allWindows = driver.getWindowHandles().toArray();
            driver.switchTo().window(allWindows[0].toString());
            Assert.assertNotEquals(driver.getTitle(), "New Window");

        }

        @AfterTest
        public void tearDown() throws Exception {
            driver.quit();
        }

}