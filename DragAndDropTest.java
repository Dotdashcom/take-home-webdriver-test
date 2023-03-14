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

public class DragAndDropTest extends BaseTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/drag_and_drop");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDragAndDrop() {
        WebElement elementA = driver.findElement(By.id("column-a"));
        WebElement elementB = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(elementA, elementB).perform();

        String textA = elementA.getText();
        String textB = elementB.getText();

        Assert.assertEquals("B", textA);
        Assert.assertEquals("A", textB);
    }
}
