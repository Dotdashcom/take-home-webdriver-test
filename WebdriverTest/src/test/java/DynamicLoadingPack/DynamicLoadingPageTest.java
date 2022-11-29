package DynamicLoadingPack;
import Main.Package.DynamicLoadingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DynamicLoadingPageTest {
    private WebDriver driver;
    private DynamicLoadingPage dynamicLoadingPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/dynamic_loading/2");
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test

    public void refreshPageChangeText() {

        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//h4[contains(text(),'Hello World!')]"), "Hello World!"));

        System.out.println(driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText());
        String StartMessage = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText();

        if (StartMessage.equals("Hello World!")) {
            System.out.println("Hello World! It successfully Started!");
            {

            }

        } else {

            System.out.println("It's Failed");
        }

    }

    @After
    public void TearDown() {
        driver.quit();
    }
}
