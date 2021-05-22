package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DynamicControlsPage;
import pages.DynamicLoadPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashDynamicLoadTest {
    WebDriver driver;
    DynamicLoadPage loadPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        loadPage = new DynamicLoadPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testDynamicLoadPage() {
        loadPage.validatePageTitle();
    }

    @Test
    public void testTextLoad() {
        loadPage.verifyHelloWorld();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
