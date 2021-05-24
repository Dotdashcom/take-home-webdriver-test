package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DragDropPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashDragDropTest {
    WebDriver driver;
    DragDropPage dragPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        dragPage = new DragDropPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testPageTitle() {
        dragPage.validatePageTitle();
    }

    @Test
    @IgnoreI
    public void testDragAndDrop() {
        dragPage.validateDefaultBoxes();
        dragPage.dragBoxes();
        dragPage.validateBoxPosition();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
