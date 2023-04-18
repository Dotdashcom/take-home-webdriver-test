import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import util.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ LoginPage.url);
    }

    @Test
    void loginSuccess() {
        LoginPage login = new LoginPage(driver);
        login.enterUserName(Constants.username);
        login.enterPassword(Constants.password);
        login.loginButtonClick();
        assert(login.getFlashText().contains(Constants.loginSuccesMsg));
    }

    @Test
    void loginFailureUserNamePasswordEmpty() {
        LoginPage login = new LoginPage(driver);
        login.loginButtonClick();
        assert(login.getFlashText().contains(Constants.loginFailureMsg));
    }

    @Test
    void loginFailureUserNameEmpty() {
        LoginPage login = new LoginPage(driver);
        login.enterPassword(Constants.password);
        login.loginButtonClick();
        assert(login.getFlashText().contains(Constants.loginFailureMsg));
    }

    @Test
    void loginFailurePasswordEmpty() {
        LoginPage login = new LoginPage(driver);
        login.enterUserName(Constants.username);
        login.loginButtonClick();
        assert(login.getFlashText().contains(Constants.loginFailureMsg));
    }

    @Test
    void loginFailureUsernameIncorrect() {
        LoginPage login = new LoginPage(driver);
        login.enterUserName(Constants.usernamePassIncorrect);
        login.enterPassword(Constants.password);
        login.loginButtonClick();
        assert(login.getFlashText().contains(Constants.loginFailureMsg));
    }

    @Test
    void loginFailurePasswordIncorrect() {
        LoginPage login = new LoginPage(driver);
        login.enterUserName(Constants.username);
        login.enterPassword(Constants.usernamePassIncorrect);
        login.loginButtonClick();
        assert(login.getFlashText().contains(Constants.loginFailureMsg));
    }

    @Test
    void loginFailureUsernameAndPasswordIncorrect() {
        LoginPage login = new LoginPage(driver);
        login.enterUserName(Constants.usernamePassIncorrect);
        login.enterPassword(Constants.usernamePassIncorrect);
        login.loginButtonClick();
        assert(login.getFlashText().contains(Constants.loginFailureMsg));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}