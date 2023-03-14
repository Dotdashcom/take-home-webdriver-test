package testPackages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class DynamicContentTest extends BaseTest {

    private WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDynamicContent() {
        driver.get("http://localhost:7080/dynamic_content");

        WebElement content = driver.findElement(By.cssSelector(".large-10.columns"));
        String initialContent = content.getText();

        for (int i = 0; i < 5; i++) {
            driver.navigate().refresh();
            WebElement newContent = driver.findElement(By.cssSelector(".large-10.columns"));
            String newContentText = newContent.getText();
            Assert.assertNotEquals("Content did not change on refresh.", initialContent, newContentText);
            initialContent = newContentText;
        }
    }
}
