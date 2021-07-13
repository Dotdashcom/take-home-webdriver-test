import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.FloatingMenuPage;

public class FloatingMenu {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/floating_menu");
    }

    @Test(testName = "Floating Menu")
    public void checkMenuShowsWhenPageIsScrolled() {
        FloatingMenuPage page = new FloatingMenuPage(driver);
        page.scrollToTheBottom();
        Assert.assertTrue(page.floatingMenu());
    }

    @AfterSuite
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
