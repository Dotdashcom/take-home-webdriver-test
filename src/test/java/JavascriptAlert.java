import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import page.JavaScriptAlertPage;

import static org.testng.AssertJUnit.assertEquals;

public class JavascriptAlert {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL + "/javascript_alerts");
    }

    @Test(testName = "Ok Alert")
    public void clickOkAlert() {
        JavaScriptAlertPage page = new JavaScriptAlertPage(driver);
        page.clickAlertButton();
        page.clickOkAlert();
        String clickAlert = page.getOutputText();
        assertEquals("Enable to click on alert", "You successfuly clicked an alert", clickAlert);
    }

    @Test(testName = "Ok Confirm")
    public void clickOkConfirm() {
        JavaScriptAlertPage page = new JavaScriptAlertPage(driver);
        page.clickConfirmButton();
        page.clickOkConfirm();
        String clickOk = page.getOutputText();
        assertEquals("Enable to confirm", "You clicked: Ok", clickOk);
    }

    @Test(testName = "Cancel Confirm")
    public void clickCancelConfirm() {
        JavaScriptAlertPage page = new JavaScriptAlertPage(driver);
        page.clickConfirmButton();
        page.clickCancelConfirm();
        String clickCancel = page.getOutputText();
        assertEquals("Enable to confirm", "You clicked: Cancel", clickCancel);
    }

    @Test(testName = "Ok Prompt and add text")
    public void InputAndClickOkPromt() {
        JavaScriptAlertPage page = new JavaScriptAlertPage(driver);
        page.clickPromptButton();
        page.clickOkPrompt("Covid 19: Stay Safe");
        String clickOkPrompt = page.getOutputText();
        assertEquals("Enable to prompt", "You entered: Covid 19: Stay Safe", clickOkPrompt);
    }

    @Test(testName = "Cancel Prompt")
    public void clickCancelPrompt() {
        JavaScriptAlertPage page = new JavaScriptAlertPage(driver);
        page.clickPromptButton();
        page.clickCancelPrompt();
        String clickCancelPrompt = page.getOutputText();
        assertEquals("Enable to prompt", "You entered: null", clickCancelPrompt);
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
