package FloatingMenuPack;
import Main.Package.FloatingMenuPage;
import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.AbstractParallelWorker;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FloatingMenuPageTest {
    private WebDriver driver;
    private FloatingMenuPage floatingMenuPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/floating_menu");
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @Test

    public void FloatingMenuTest() throws Exception {

        WebElement FloatHome = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        WebElement FloatNews = driver.findElement(By.xpath("//a[contains(text(),'News')]"));
        WebElement FloatContact = driver.findElement(By.xpath("//a[contains(text(),'Contact')]"));
        WebElement FloatAbout = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
        WebElement FloatTitle = driver.findElement(By.xpath("//h3[contains(text(),'Floating Menu')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,2000)");

        Thread.sleep(5000);


        boolean boolean1 = FloatTitle.equals(ExpectedConditions.visibilityOf(FloatTitle));
        boolean boolean2 = FloatHome.equals(ExpectedConditions.invisibilityOf(FloatHome));
        boolean boolean3 = FloatContact.equals(ExpectedConditions.invisibilityOf(FloatContact));
        boolean boolean4 = FloatNews.equals(ExpectedConditions.invisibilityOf(FloatNews));
        boolean boolean5 = FloatAbout.equals(ExpectedConditions.invisibilityOf(FloatAbout));


        if (boolean1) {
            System.out.println("FloatTitle is visible");

        } else {
            System.out.println("After scroll FloatTitle is invisible. Success");
        }
        if (boolean2) {
            System.out.println("FloatHome is Invisible. FAIL");
        } else {
            System.out.println("FloatMenu is Visible!!! FloatHome is Visible. Success!!!");
        }
        if (boolean3) {
            System.out.println("FloatContact is Invisible. FAIL");
        } else {
            System.out.println("FloatMenu is Visible!!! FloatContact is Visible. Success!!!");
            if (boolean4) {
                System.out.println("FloatNews is Invisible. FAIL");
            } else {
                System.out.println("FloatMenu is Visible!!! FloatNews is Visible. Success!!!");
                if (boolean5) {
                    System.out.println("FloatAbout is Invisible. FAIL");
                } else {
                    System.out.println("FloatMenu is Visible!!! FloatAbout is Visible. Success!!!");

                }

            }

        }

    }

    @After
    public void TearDown() {
        driver.quit();
    }
}



