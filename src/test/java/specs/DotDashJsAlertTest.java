package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.JsAlertsPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashJsAlertTest {
    WebDriver driver;
    JsAlertsPage alertPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        alertPage = new JsAlertsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testJsAlerts() {
        alertPage.validatePageTitle();
        alertPage.verifyJsAlert();
        alertPage.verifyJsConfirm();
        alertPage.verifyJsPrompt();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
