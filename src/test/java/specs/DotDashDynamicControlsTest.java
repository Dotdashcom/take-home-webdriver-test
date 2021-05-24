package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DynamicControlsPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashDynamicControlsTest {
    WebDriver driver;
    DynamicControlsPage controlsPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        controlsPage = new DynamicControlsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testDynamicControls() {
        controlsPage.verifyDefaultOptions();
        controlsPage.verifyRemove();
        controlsPage.verifyAdd();
        controlsPage.verifyEnable();
        controlsPage.verifyDisable();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}