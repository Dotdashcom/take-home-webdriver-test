import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileUpload {
        private WebDriver driver;
        private String baseUrl;
        private String filePath = "C://Users/Shuai/selenium-logo.png";

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
        public void TestFileUpload() throws Exception {
            driver.get(baseUrl + "upload");
            Thread.sleep(2000);
            // select file and click submit button
            File file = new File("./selenium-logo.png");

            driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
            Thread.sleep(2000);
            driver.findElement(By.id("file-submit")).click();
            //assert that message on upload is as expected
            Thread.sleep(3000);
            String actualMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
            String expectedMessage = "File Uploaded!";
            Assert.assertEquals(actualMessage, expectedMessage);

        }

        @AfterTest
        public void tearDown() throws Exception {
           // driver.close();
            driver.quit();
        }

}