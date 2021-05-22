package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HoverPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashHoverTest {
    WebDriver driver;
    HoverPage hoverPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        hoverPage = new HoverPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testHover() {
        hoverPage.validatePageTitle();
        hoverPage.hoverOverImages();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
