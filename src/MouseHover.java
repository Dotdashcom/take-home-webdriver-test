import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;;

public class MouseHover {
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
        public void TestHover1() throws Exception {
            driver.get(baseUrl + "hovers");
            Thread.sleep(2000);
            Actions action = new Actions(driver);
            WebElement container = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]"));

            action.moveToElement(container);
            action.perform();
            Thread.sleep(2000);
            String display = container.findElement(By.className("figcaption")).getCssValue("display");
            Assert.assertEquals(display, "block");

        }

        @Test(priority = 1)
        public void TestHover2() throws Exception {
            driver.get(baseUrl + "hovers");
            Thread.sleep(2000);
            Actions action = new Actions(driver);
            WebElement container = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]"));

            action.moveToElement(container);
            action.perform();
            Thread.sleep(2000);
            String display = container.findElement(By.className("figcaption")).getCssValue("display");
            Assert.assertEquals(display, "block");

        }

        @Test(priority = 2)
        public void TestHover3() throws Exception {
            driver.get(baseUrl + "hovers");
            Thread.sleep(2000);
            Actions action = new Actions(driver);
            WebElement container = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]"));

            action.moveToElement(container);
            action.perform();
            Thread.sleep(2000);
            String display = container.findElement(By.className("figcaption")).getCssValue("display");
            Assert.assertEquals(display, "block");

        }

        @AfterTest
        public void tearDown() throws Exception {
            driver.quit();
        }

}