package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DropDownPage;
import pages.DynamicContentPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashDynamicContentTest {
    WebDriver driver;
    DynamicContentPage contentPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        contentPage = new DynamicContentPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testPageTitle() {
        contentPage.validatePageTitle();
    }

    @Test
    public void testDynamicContent() {
        String[] orgContentArr = contentPage.readContentTexts();
        driver.navigate().refresh();
        contentPage.validateContentChange(orgContentArr);
        String[] intermittentContent = contentPage.readContentTexts();
        driver.navigate().refresh();
        contentPage.validateContentChange(intermittentContent);
    }

    @After
    public void close(){
        driver.close();
    }
}
