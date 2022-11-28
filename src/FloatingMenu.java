import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FloatingMenu {

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
        public void TestFloatingMenu() throws Exception {
            driver.get(baseUrl + "floating_menu");
            Thread.sleep(2000);
            // scroll y by 500
            JavascriptExecutor exec = (JavascriptExecutor) driver;
            exec.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            Boolean menu = driver.findElement(By.id("menu")).isDisplayed();
            Assert.assertEquals(menu, true);
        }

        @AfterTest
        public void tearDown() throws Exception {
           // driver.close();
            driver.quit();
        }

}