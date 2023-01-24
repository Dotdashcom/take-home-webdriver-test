import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FloatingMenu {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/floating_menu");
        driver.manage().window().maximize();
    }
    @Test
    public void floatTest(){
        //Test scrolls page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement menu = driver.findElement(By.xpath("//div[@id=\"menu\"]"));

        //Assert floating menu is displayed
        Assert.assertTrue(menu.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
