import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ContentMenu {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.get(Utils.BASE_URL + "/context_menu");
    }

    @Test(testName = "Content Menu")
    public static void checkboxChecked() {
        WebElement rightClick = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions action = new Actions(driver);
        action.contextClick(rightClick).perform();
        String alert = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(alert, "You selected a context menu");
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
