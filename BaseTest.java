package testPackages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class BaseTest {


    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        baseUrl = "http://localhost:7080";
        driver = new ChromeDriver();
    }

    @Test
    public void testExample() throws Exception {
        driver.get(baseUrl);

        String pageTitle = driver.getTitle();
        Assert.assertEquals("The Internet", pageTitle);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
