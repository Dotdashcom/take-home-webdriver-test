import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicControls {
    WebDriver driver;
    @BeforeMethod
      public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/dynamic_controls");
        driver.manage().window().maximize();
        }
        @Test
        public void removeBtn() throws InterruptedException {
            //Test clicks Remove button and uses explicit wait
            WebElement Removebtn;
            WebDriverWait wait = new WebDriverWait(driver, 60);
            Removebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type=\"button\" and contains(text(),\"Remove\")]")));
            Removebtn.click();
           Thread.sleep(3000);

            //Test asserts that the checkbox is gone
            WebElement checkbox = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
            Assert.assertTrue(checkbox.isDisplayed());
            //Test clicks on Add Button and uses explicit wait.
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add']")));
            checkbox.click();
            Thread.sleep(5000);

            //Test asserts that the checkbox is present.
            WebElement checkbox2 = driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
            Assert.assertTrue(checkbox2.isDisplayed());
            //Test clicks on the Enable Button and uses explicit wait
            WebElement Enable;
            Enable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Enable']")));
            Enable.click();
            Thread.sleep(5000);
            //Test asserts that the text box is enabled
            WebElement EnableTextbox = driver.findElement(By.xpath("//button[@type=\"button\" and @onclick=\"swapInput()\"]"));
            Assert.assertTrue(EnableTextbox.isEnabled());
            Thread.sleep(5000);
            //Test clicks on the Disable Button and uses explicit wait
            WebElement Disable;
            Disable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"button\" and contains(text(),'Disable')]")));
            Disable.click();
            Thread.sleep(5000);
            //Test asserts that the text box is disabled
            WebElement Disabletextbox;
            Disabletextbox = driver.findElement(By.xpath("//input[@type=\"text\"]"));
            Assert.assertFalse(Disabletextbox.isEnabled());
            Thread.sleep(5000);
        }
        @AfterMethod
        public void tearDown(){


        driver.quit();
    }
}
