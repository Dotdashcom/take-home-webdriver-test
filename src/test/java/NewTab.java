import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NewTab {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/windows");
        driver.manage().window().maximize();
    }
    @Test
    public void newTabTest() throws InterruptedException {

        //Test clicks on the Click Here link
        driver.findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();
        Thread.sleep(2000);

        //Test asserts that a new tab is opened with text New Window
        driver.getWindowHandles();
        List<String> window = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(window.get(1));

        String Title = driver.getTitle();
        String exp = "New Window";
        Assert.assertEquals(Title, exp);
    }
    @AfterMethod
            public void tearDown(){
            driver.quit();
        }
    }
