import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/hovers");
        driver.manage().window().maximize();
    }
    @Test
    public void mouseHover() throws InterruptedException {
        //Test does a mouse hover on each image & asserts that additional information is displayed for each image
        Actions act = new Actions(driver);

        act.moveToElement(driver.findElement(By.xpath("//div[@class=\"figure\"][1]"))).build().perform();

        driver.findElement(By.xpath("//h5[contains(text(),\"name: user1\")]")).isDisplayed();

        act.moveToElement(driver.findElement(By.xpath("(//img[@alt='User Avatar'])[2]"))).build().perform();

        driver.findElement(By.xpath("//h5[contains(text(),\"name: user2\")]")).isDisplayed();

        act.moveToElement(driver.findElement(By.xpath("(//img[@alt='User Avatar'])[3]"))).build().perform();

        driver.findElement(By.xpath("//h5[contains(text(),\"name: user3\")]")).isDisplayed();

        Thread.sleep(2000);
    }
    @AfterMethod
            public void tearDown(){
        driver.quit();
    }
}

