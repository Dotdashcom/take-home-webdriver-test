import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrames {
    WebDriver driver;
    @BeforeMethod
            public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/iframe");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class=\"tox-icon\"]")).click();
    }
    @Test
    public void iframeTest() throws InterruptedException {
        //switch to frame
        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);
        //used locator to locate element again as element went stale
        WebElement frame1 = driver.findElement(By.xpath("//body[@id=\"tinymce\"]"));
        //type some text
        frame1.clear();
        frame1.sendKeys("Have a great day!");
        Thread.sleep(2000);
        //Test asserts that the typed text is as expected
        String act = frame1.getText();
        String exp = "Have a great day!";
        Assert.assertEquals(act, exp);
    }
    @AfterMethod
            public void tearDown(){
        driver.quit();

    }
}
