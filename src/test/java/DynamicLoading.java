import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.DynamicLoadingPage;

import static org.testng.AssertJUnit.assertEquals;

public class DynamicLoading {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/dynamic_loading/2");
    }

    @Test(testName = "Dynamic Loading")
    public void StartAndWaitForMessage() {
        DynamicLoadingPage page = new DynamicLoadingPage(driver);
        page.clickStartButton();
        String message = page.getMessage();
        assertEquals("Error getting the expected message", "Hello World!", message);
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
