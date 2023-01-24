import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationMessage {
    WebDriver driver;
    @BeforeMethod
            public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/notification_message_rendered");
        driver.manage().window().maximize();
    }
    @Test
            public void notemsgTest() throws InterruptedException {
           WebElement demo;
        //Test clicks on the Click Here link a multiple times
        for (int i = 0; i <= 10; i++) {
            demo = driver.findElement(By.xpath("//a[contains(text(),\"Click here\")]"));
            demo.click();
            i++;
            Thread.sleep(1000);
            //Test asserts
            WebElement message = driver.findElement(By.xpath("//*[@id='flash']"));
            Assert.assertTrue(message.getText().contains("Action successful")
                    || message.getText().contains("Action unsuccesful, please try again")
                    || message.getText().contains("Action Unsuccessful"));
        }
        }

        //Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again”
        // and “Action Unsuccessful” messages show on click.
  @AfterMethod
        public void tearDown(){
            driver.quit();
        }


    }

