import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {

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
        public void TestOptionOne() throws Exception {
            driver.get(baseUrl + "dropdown");
            // Select drop down element
            Select dropdown = new Select(driver.findElement(By.id("dropdown")));
            Thread.sleep(2000);
            //Select 1st option
            dropdown.selectByVisibleText("Option 1");
            Thread.sleep(2000);
            String expectedOption = "Option 1";
            String actualOption = dropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption, expectedOption);

        }

        @Test
        public void TestOptionTwo() throws Exception {
            driver.get(baseUrl + "dropdown");
            // Select drop down element
            Select dropdown = new Select(driver.findElement(By.id("dropdown")));
            Thread.sleep(2000);
            //Select 2nd option
            dropdown.selectByVisibleText("Option 2");
            Thread.sleep(2000);
            String expectedOption = "Option 2";
            String actualOption = dropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption, expectedOption);
        }

        @AfterTest
        public void tearDown() throws Exception {
           // driver.close();
            driver.quit();
        }

}