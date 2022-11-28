import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {

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
        public void TestDragDrop() throws Exception {
            driver.get(baseUrl + "drag_and_drop");
            Thread.sleep(2000);
            Actions action = new Actions(driver);

            WebElement From = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
            WebElement To = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
            System.out.println(From.getAttribute("offsetTop"));
            System.out.println(To.getAttribute("offsetTop"));
            System.out.println(From.getAttribute("offsetLeft"));
            System.out.println(To.getAttribute("offsetLeft"));

//            action.clickAndHold(From)
//                    .pause(Duration.ofSeconds(1))
//                    .moveByOffset(215, 0)
//
//                    .pause(Duration.ofSeconds(1))
//                    .release().build().perform();
           // action.clickAndHold(From).moveByOffset(215, 30).release().build().perform();

            action.dragAndDropBy(From, 215, 0).build().perform();
            //builder.moveByOffset(0, 215).clickAndHold(To).dragAndDrop().build().perform();
            Thread.sleep(3000);

            String expectedFirstColumnText = "B";
            String expectedSecondColumnText = "A";

            String actualFirstColumnText = From.getText();
            System.out.println("actualFirstColumnText...."+actualFirstColumnText);
            String actualSecondColumnText = To.getText();


        }

        @AfterTest
        public void tearDown() throws Exception {
            driver.quit();
        }

}