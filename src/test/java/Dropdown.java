import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.DropdownPage;

import static org.testng.AssertJUnit.assertTrue;

public class Dropdown {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/dropdown");
    }

    @Test(testName = "Dropdown Option 1")
    public void selectOption1() {
        DropdownPage page = new DropdownPage(driver);
        page.selectOption("Option 1");
        assertTrue("Unexpected option was selected", page.getSelectedValue().equals("Option 1"));
    }

    @Test(testName = "Dropdown Option 2")
    public void selectOption2() {
        DropdownPage page = new DropdownPage(driver);
        page.selectOption("Option 2");
        assertTrue("Unexpected option was selected", page.getSelectedValue().equals("Option 2"));
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
