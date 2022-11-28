import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class DynamicLoading {
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
        public void TestDynamicLoading() throws Exception {
            driver.get(baseUrl + "dynamic_loading/2");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
            Thread.sleep(10000);
            String finishText = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4")).getText();
            Thread.sleep(2000);
            Assert.assertEquals(finishText, "Hello World!");

        }

        @AfterTest
        public void tearDown() throws Exception {
            driver.quit();
        }

}