import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenu {
        WebDriver driver;
        @BeforeMethod
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("http://localhost:7080/context_menu");
            driver.manage().window().maximize();
        }
        @Test
        public void contextClick() {
           WebElement contextmenu = driver.findElement(By.xpath("//div[@id=\"hot-spot\"]"));
            Actions act = new Actions(driver);
          act.contextClick(contextmenu).perform();
          Alert context = driver.switchTo().alert();
          String actual = context.getText();
          String exp = "You selected a context menu";
          Assert.assertEquals(actual,exp,"The alert menu text did not match");

        }
        @AfterMethod
        public void tearDown(){

        driver.quit();

       //Thread.sleep(3000);
    }
}
