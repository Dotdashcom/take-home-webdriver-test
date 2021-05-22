package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.IframePage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashIframeTest {
    WebDriver driver;
    IframePage iFramePage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        iFramePage = new IframePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testIFrameTextTyping() {
        iFramePage.verifyIframe();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
