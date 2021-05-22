package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckboxPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashCheckboxTest {
    WebDriver driver;
    CheckboxPage checkboxPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        checkboxPage = new CheckboxPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testPageTitle() {
        checkboxPage.validatePageTitle();
    }

    @Test
    public void testCheckboxDefault() {
        checkboxPage.validateCheckBoxChecked(1);
    }

    @Test
    public void testCheckboxCheck() {
        checkboxPage.check(0);
        checkboxPage.validateCheckBoxChecked(0);
    }

    @Test
    public void testCheckboxUncheck() {
        checkboxPage.check(1);
        checkboxPage.validateCheckBoxUnchecked(1);
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
