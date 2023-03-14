package testPackages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuTest extends BaseTest {

    private WebDriver driver;
    private Actions action;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.get("http://localhost:7080/context_menu");
    }

    @Test
    public void testContextMenu() {
        WebElement box = driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals("You selected a context menu", alertText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
