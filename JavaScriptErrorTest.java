import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptErrorTest{

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testJavaScriptError() {
        driver.get("http://localhost:7080/javascript_error");
        String errorText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Error message does not contain expected text",
                errorText.contains("Cannot read property 'xyz' of undefined"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
