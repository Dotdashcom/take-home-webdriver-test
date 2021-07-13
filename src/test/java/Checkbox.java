import page.CheckboxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Checkbox {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/checkboxes");
    }

    @Test(testName = "Checkbox checked")
    public static void checkboxChecked() {
        CheckboxPage page = new CheckboxPage(driver);
        boolean Checkbox1 = page.Checkbox1ButtonCheck();
        boolean Checkbox2 = page.Checkbox2ButtonCheck();

        if (!Checkbox1) {
            page.performCheckbox1ButtonClick();
        }
        if (!Checkbox2) {
            page.performCheckbox2ButtonClick();
        }
        boolean Checkbox3 = page.Checkbox1ButtonCheck();
        boolean Checkbox4 = page.Checkbox2ButtonCheck();
        Assert.assertTrue(Checkbox3);
        Assert.assertTrue(Checkbox4);
    }

    @Test(testName = "Checkbox unchecked")
    public static void checkboxUnchecked() {
        CheckboxPage page = new CheckboxPage(driver);
        boolean Checkbox1 = page.Checkbox1ButtonCheck();
        boolean Checkbox2 = page.Checkbox2ButtonCheck();
        if (Checkbox1) {
            page.performCheckbox1ButtonClick();
        }
        if (Checkbox2) {
            page.performCheckbox2ButtonClick();
        }
        boolean Checkbox3 = page.Checkbox1ButtonCheck();
        boolean Checkbox4 = page.Checkbox2ButtonCheck();

        Assert.assertFalse(Checkbox3);
        Assert.assertFalse(Checkbox4);
    }

    @AfterSuite
    public void teardown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
