import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.DynamicContentPage;

import static org.testng.AssertJUnit.assertFalse;

public class DynamicContent {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/dynamic_content");
    }

    @Test(testName = "DynamicContent")
    public void dynamicContentDiffersOnRefreshes() {
        DynamicContentPage page = new DynamicContentPage(driver);
        String A = page.getDynamicContent();
        driver.navigate().refresh();
        String B = page.getDynamicContent();
        driver.navigate().refresh();
        String C = page.getDynamicContent();

        assertFalse("Different content should get display", A.equals(B));
        assertFalse("Different content should get display", A.equals(C));
        assertFalse("Different content should get display", B.equals(C));
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
