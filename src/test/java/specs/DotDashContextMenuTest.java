package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContextMenuPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashContextMenuTest {
    WebDriver driver;
    ContextMenuPage contextPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        contextPage = new ContextMenuPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testPageTitle() {
        contextPage.validatePageTitle();
    }

    @Test
    public void testAlert() {
        contextPage.rightClickElement();
        contextPage.validateAlertPresent();
        contextPage.acceptAlert();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
