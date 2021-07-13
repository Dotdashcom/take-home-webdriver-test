import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.IFramePage;

import static org.testng.AssertJUnit.assertEquals;

public class IFrame {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/iframe");
    }

    @Test(testName = "add text in Editor")
    public void Editor() {
        final String input = "Stay safe Stay at Home";
        IFramePage editor = new IFramePage(driver);
        editor.clearEditor();
        editor.inputEditor(input);
        String contents = editor.getEditorText();
        assertEquals("error with editor", input, contents);
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
