import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.DynamicControlPage;

import static org.testng.AssertJUnit.assertEquals;

public class DynamicControls {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/dynamic_controls");
    }

    @Test(priority = 1)
    public void removeCheckbox() {
        DynamicControlPage page = new DynamicControlPage(driver);
        page.clickRemoveCheckboxButton();
        String message = page.getMessage();
        assertEquals("It's gone!", message);
    }

    @Test(priority = 2)
    public void addCheckbox() {
        DynamicControlPage page = new DynamicControlPage(driver);
        page.clickAddCheckboxButton();
        String message = page.getMessage();
        assertEquals("It's back!", message);
    }

    @Test(priority = 3)
    public void enableTextField() {
        DynamicControlPage page = new DynamicControlPage(driver);
        page.clickEnableButton();
        String message = page.getMessage();
        assertEquals("It's enabled!", message);
    }

    @Test(priority = 4)
    public void disableTextField() {
        DynamicControlPage page = new DynamicControlPage(driver);
        page.clickDisableButton();
        String message = page.getMessage();
        assertEquals("It's disabled!", message);
    }

    @AfterSuite
    public void teardown() throws InterruptedException {
        driver.quit();
    }
}
