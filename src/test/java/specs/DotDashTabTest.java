package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.WindowsPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashTabTest {
    WebDriver driver;
    WindowsPage tabPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        tabPage = new WindowsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testHover() {
        tabPage.validatePageTitle();
        tabPage.verifyNewTab();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
