package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashLoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testValidLogin() {
        loginPage.login(CommonUtils.getValidCreds()[0],CommonUtils.getValidCreds()[1]);
        loginPage.validateSecureHeader();
    }

    @Test
    public void testInvalidUsername() {
        loginPage.login(CommonUtils.getInvalidCreds()[0],CommonUtils.getInvalidCreds()[1]);
        loginPage.validateUsernameError();
    }

    @Test
    public void testInvalidPassword() {
        loginPage.login(CommonUtils.getValidCreds()[0],CommonUtils.getInvalidCreds()[1]);
        loginPage.validatePasswordError();
    }

    @After
    public void close(){
        driver.close();
    }
}
