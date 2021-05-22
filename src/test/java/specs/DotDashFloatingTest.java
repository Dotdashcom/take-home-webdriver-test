package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DynamicControlsPage;
import pages.FilePage;
import pages.FloatingMenuPage;
import utils.CommonUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DotDashFloatingTest {
    WebDriver driver;
    FloatingMenuPage menuPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        menuPage = new FloatingMenuPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testFloatingMenu() {
        menuPage.verifyFloat();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
