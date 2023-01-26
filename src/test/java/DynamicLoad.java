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

public class DynamicLoad {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/dynamic_loading/2");
        driver.manage().window().maximize();
    }
    @Test
    public void dynamicLoad() throws InterruptedException {
        //Test clicks the start button and uses explicit wait
        WebElement start;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        start = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        start.click();
        //Thread.sleep(3000);
        //Test asserts that “Hello World!” text is displayed
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"finish\"]/child::h4[contains(text(),\"Hello World!\")]")));
        Thread.sleep(3000);
        Assert.assertTrue(text.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();

    }
}
