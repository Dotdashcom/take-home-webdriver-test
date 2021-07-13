import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.NewTabPage;

import static org.testng.AssertJUnit.assertEquals;

public class NewTab {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/windows");
    }

    @Test(testName = "New Tab open successfully")
    public void newTab() {
        NewTabPage page = new NewTabPage(driver);
        page.clickLinkToLaunchNewTab();
        String newPage = page.getTabText();
        assertEquals("Unable to open new tab", "New Window", newPage);
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
