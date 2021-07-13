import page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        driver.get(Utils.BASE_URL + "/page");
    }

    @Test(testName = "Login")
    public static void login() {
        LoginPage webForm = new LoginPage(driver);
        webForm.inputValidCredentials();
        webForm.performSubmitButtonClick();
        String title = webForm.getTitleText();
        System.out.println(title);
        Assert.assertEquals(title, "Welcome to the Secure Area. When you are done click logout below.");
        webForm.performLogoutButtonClick();
    }

    @Test(testName = "LoginFailure")
    public static void loginFailure() {
        LoginPage webForm = new LoginPage(driver);
        webForm.inputInvalidCredentials();
        webForm.performSubmitButtonClick();
        String flash1 = webForm.getFlashText();
        String flash = flash1.substring(0, flash1.length() - 1).trim();
        System.out.print(flash);
        Assert.assertEquals(flash, "Your username is invalid!");
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}