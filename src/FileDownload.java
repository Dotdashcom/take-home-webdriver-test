import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileDownload {
        private WebDriver driver;
        private String baseUrl;
        private String downloadPath = "C://Users/Default/Downloads";
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
        public void TestFileDownload() throws Exception {
            driver.get(baseUrl + "download");
            Thread.sleep(2000);
            //String downloadPath = downloadPath;
            String expectedFileName = "some-file.txt";
            //click filename to download file
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

            File file = new File(downloadPath + expectedFileName);
            Thread.sleep(2000);
            Assert.assertTrue(file.exists());
            //confirm file exists in downloads path, delete it
            if (file.exists())
                file.delete();

        }

        @AfterTest
        public void tearDown() throws Exception {
            driver.quit();
        }

}