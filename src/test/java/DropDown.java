import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDown {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/dropdown");
        driver.manage().window().maximize();
    }
    @Test
    public void option1() throws InterruptedException {
        Select s1 = new Select(driver.findElement(By.id("dropdown")));
        s1.selectByVisibleText("Option 1");
        Assert.assertEquals("Option 1",s1.getFirstSelectedOption().getText());
        Thread.sleep(3000);
    }
    @Test
    public void option2() throws InterruptedException {
        Select s1 = new Select(driver.findElement(By.id("dropdown")));
         s1.selectByVisibleText("Option 2");
        Assert.assertEquals("Option 2",s1.getFirstSelectedOption().getText());
        Thread.sleep(3000);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    }

