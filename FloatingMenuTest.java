package testPackages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FloatingMenuTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/floating_menu");
    }

    @Test
    public void testFloatingMenu() {
        driver.navigate().to("http://localhost:7080/floating_menu#about");
        Assert.assertTrue(driver.findElement(By.cssSelector(".nav-floating")).isDisplayed());

        driver.navigate().to("http://localhost:7080/floating_menu#home");
        Assert.assertTrue(driver.findElement(By.cssSelector(".nav-floating")).isDisplayed());

        driver.navigate().to("http://localhost:7080/floating_menu#news");
        Assert.assertTrue(driver.findElement(By.cssSelector(".nav-floating")).isDisplayed());

        driver.navigate().to("http://localhost:7080/floating_menu#contact");
        Assert.assertTrue(driver.findElement(By.cssSelector(".nav-floating")).isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
