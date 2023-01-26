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

public class DynamicContent {
    WebDriver  driver;
    @BeforeMethod
     public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(" http://localhost:7080/dynamic_content");
        driver.manage().window().maximize();
    }
    @Test
    public void dynamicTest() throws InterruptedException {
        driver.navigate().refresh();
        WebElement refresh1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img"));

        driver.navigate().refresh();
        WebElement refresh2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img"));
        String image2 = refresh2.getAttribute("src");

        Assert.assertNotEquals(refresh1,refresh2,"Content is not changing after each refresh");
            Thread.sleep(2000);
        }

        @AfterMethod
        public void tearDown () {
            driver.quit();
        }


    }
