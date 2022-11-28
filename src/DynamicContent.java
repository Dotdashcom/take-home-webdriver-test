import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicContent {
        private WebDriver driver;
        private String baseUrl;
        private LocalStorage local;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();


        @BeforeTest
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver","BrowserWebDrivers\\chromedriver.exe");

            driver = new ChromeDriver();
            baseUrl = "http://localhost:7080/";
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
            local = ((WebStorage) driver).getLocalStorage();
        }

        @Test
        public void TestFirstRefreshValue() throws Exception {
            driver.get(baseUrl + "dynamic_content?with_content=static");
            // Get Initial third Row value
            WebElement thirdRow = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]"));
            String thirdRowValue = thirdRow.getText();
            // set value in localStorage
            local.setItem("thirdRow", thirdRowValue);
            Thread.sleep(1000);
            //refresh the page
            driver.navigate().refresh();
            Thread.sleep(3000);
            // get new third row value
            WebElement thirdRowNew = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]"));
            String thirdRowNewValue = thirdRowNew.getText();
            //get last third row value from localStorage and clear the localStorage
            String OldValue = local.getItem("thirdRow");
            local.clear();
            Thread.sleep(1000);
            // set new value in localStorage
            local.setItem("thirdRow", thirdRowNewValue);
            Thread.sleep(1000);
            Assert.assertNotEquals(thirdRowNewValue, OldValue);
        }

        @Test
        public void TestSecondRefreshValue() throws Exception {
            Thread.sleep(1000);
            // refresh the page
            driver.navigate().refresh();
            // Thread.sleep(2000);
            WebElement thirdRow = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]"));
            String thirdRowValue = thirdRow.getText();
            Thread.sleep(1000);
            // get value from localStorage
            String SecondValue = local.getItem("thirdRow");
            local.clear();
            Thread.sleep(1000);

            Assert.assertNotEquals(thirdRowValue, SecondValue);

        }

        @AfterTest
        public void tearDown() throws Exception {
            driver.quit();
        }

}