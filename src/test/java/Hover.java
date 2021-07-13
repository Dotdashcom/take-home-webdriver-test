import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.HoverPage;

import static org.testng.AssertJUnit.assertTrue;

public class Hover {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/hovers");
    }

    @Test(testName = "Hover")
    public void getCaptionOnHover() {
        HoverPage page = new HoverPage(driver);
        page.imageHover(0);
        String user0Caption = page.getVisibleCaption(0);
        page.imageHover(1);
        String user1Caption = page.getVisibleCaption(1);
        page.imageHover(2);
        String user2Caption = page.getVisibleCaption(2);
        assertTrue("Caption error", user0Caption.contains("name: user1") && user0Caption.contains("View profile"));
        assertTrue("Caption error", user1Caption.contains("name: user2") && user1Caption.contains("View profile"));
        assertTrue("Caption error", user2Caption.contains("name: user3") && user2Caption.contains("View profile"));
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
