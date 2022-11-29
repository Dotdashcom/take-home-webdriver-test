package IFramePack;
import Main.Package.IFramePage;
import org.asynchttpclient.util.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class IFramePageTest {
    static WebDriver driver;
    private IFramePage iFramePage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/iframe");
        IFramePage iFramePage = new IFramePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @Test

    public void IFrameTest() throws Exception {


        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(5000);
        driver.findElement(By.id("tinymce")).clear();

driver.findElement(By.id("tinymce")).sendKeys("Hello World!!! Andre is here!");

        WebElement TextField = driver.findElement(By.id("tinymce"));

boolean MyText1 = TextField.getText().equals("Hello World!!! Andre is here!");


        if (MyText1) {
            System.out.println("Input works well!");
        }else{
            System.out.println("Fail");
        }
    }

@After
public void TearDown() {
    driver.quit();
}
}
