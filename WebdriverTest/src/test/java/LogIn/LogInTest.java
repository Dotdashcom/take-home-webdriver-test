package LogIn;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;
import org.junit.Test;
import Main.Package.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LogInTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/login");
        LoginPage loginPage = new LoginPage(driver);
    }

    @Test
    public void logInSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logInWithInvalidCreds("tomsmith", "SuperSecretPassword!");
        String successMessageLogInText2 = loginPage.getSuccessMessageLogIn2();
        Assert.assertEquals("Welcome to the Secure Area. When you are done click logout below.", successMessageLogInText2);
        String successMessageLogInText1 = loginPage.getSuccessMessageLogIn1();
        Assert.assertEquals("You logged into a secure area!\n" +
                "×", successMessageLogInText1);

    }

    @Test
    public void logInFail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logInWithInvalidCreds("asdjasd", "askdjaksd!");
        String errorText = loginPage.getErrorText();
        Assert.assertEquals("Your username is invalid!\n" +
                "×", errorText);
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Login Page",heading);
    }

    @Test
    public void logInWithEmptyCreds() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logInWithInvalidCreds("", "");
        String errorText = loginPage.getErrorText();
        Assert.assertEquals("Your username is invalid!\n" +
                "×", errorText);
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Login Page",heading);
    }

@After
public void TearDown() {
    driver.quit();
    }
}
