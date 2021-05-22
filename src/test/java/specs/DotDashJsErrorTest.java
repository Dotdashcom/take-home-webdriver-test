package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.JsAlertsPage;
import pages.JsErrorPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashJsErrorTest {
    WebDriver driver;
    JsErrorPage errorPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        errorPage = new JsErrorPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testJsError() {
        errorPage.validateJsError();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
