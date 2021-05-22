package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DragDropPage;
import pages.DropDownPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashDropDownTest {
    WebDriver driver;
    DropDownPage dropPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        dropPage = new DropDownPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testPageTitle() {
        dropPage.validatePageTitle();
    }

    @Test
    public void testDropDownSelect() {
        dropPage.verifySelectOption("1");
        driver.navigate().refresh();
        dropPage.verifySelectOption("2");
        driver.navigate().refresh();
        dropPage.verifySelectOption("1");
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
