import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragDrop {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/drag_and_drop");
    }

    @Test(testName = "Drag & Drop")
    public static void checkboxChecked() {
        WebElement A = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));
        WebElement B = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]"));
        Actions action = new Actions(driver);
        action.clickAndHold(A).pause(Duration.ofSeconds(2)).
                moveToElement(B).pause(Duration.ofSeconds(5)).release().pause(Duration.ofSeconds(10)).build().perform();
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}

