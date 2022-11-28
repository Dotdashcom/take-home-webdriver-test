import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DynamicControls {
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

        @Test(priority=0)
        public void TestRemoveButton() throws Exception {
            driver.get(baseUrl + "dynamic_controls");
            Thread.sleep(2000);
            //click remove button
            WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
            removeButton.click();
            Thread.sleep(4000);
            // get list of available checkboxes on the page, there should be None
            List checkbox = driver.findElements(By.xpath("//*[@id=\"checkbox\"]/input"));
            // assert that there is 0 checkboxes after clicking remove button
            Assert.assertEquals(checkbox.size(), 0);

        }

        @Test(priority=1)
        public void TestAddButton() throws Exception {
            Thread.sleep(1000);
            WebElement addButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
            addButton.click();
            Thread.sleep(4000);
            // get list of available checkboxes on the page, there should be one
            List checkbox = driver.findElements(By.xpath("//*[@id=\"checkbox\"]"));

            Assert.assertEquals(checkbox.size(), 1);
        }

        @Test(priority=2)
        public void TestEnableButton() throws Exception {
            Thread.sleep(1000);
            // click enable button
            WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
            enableButton.click();
            Thread.sleep(4000);
            //check if inout box is enabled
            WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
            Boolean inputBoxEnabled = inputBox.isEnabled();
            Thread.sleep(2000);
            // assert input box is enabled
            Assert.assertEquals(inputBoxEnabled, true);
        }

        @Test(priority=3)
        public void TestDisableButton() throws Exception {
            Thread.sleep(1000);
            WebElement disableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
            disableButton.click();
            Thread.sleep(4000);
            //check if inout box is disabled
            WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
            Boolean inputBoxDisabled = inputBox.isEnabled();
            // assert input box is Not enabled
            Assert.assertEquals(inputBoxDisabled, false);
        }

        @AfterTest
        public void tearDown() throws Exception {
            driver.quit();
        }

}