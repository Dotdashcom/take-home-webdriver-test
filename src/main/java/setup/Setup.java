package setup;

import constants.CheckBoxStatus;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import pages.CheckboxPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class Setup {
    WebDriver driver;
    LoginPage objLoginPage;
    CheckboxPage objCheckboxPage;

    @BeforeTest
    public void setup() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:7080");
    }

    @Test
    public void test_login_success() {
        objLoginPage = new LoginPage(driver);
        objLoginPage.enterUsername("tomsmith");
        objLoginPage.enterPassword("SuperSecretPassword!");
        objLoginPage.clickOnLoginButton();
        objLoginPage.wait(1);
        objLoginPage.softAssertLoginResult(false);
    }

    @Test
    public void test_login_failure() {
        objLoginPage = new LoginPage(driver);
        objLoginPage.enterUsername("tomsmitH");
        objLoginPage.enterPassword("supersecretpassword!");
        objLoginPage.clickOnLoginButton();
        objLoginPage.wait(1);
        objLoginPage.softAssertLoginResult(true);
    }

    @Test
    public void test_check_checkbox() {
        objCheckboxPage = new CheckboxPage(driver);
        objCheckboxPage.findCheckBox(1);
        objCheckboxPage.resetCheckBoxTo(1, CheckBoxStatus.UNCHECKED);
        objCheckboxPage.clickCheckBox(1);
        objLoginPage.wait(1);
        objCheckboxPage.assertCheckboxResult(1, CheckBoxStatus.CHECKED);
    }

    @Test
    public void test_uncheck_checkbox() {
        objCheckboxPage = new CheckboxPage(driver);
        objCheckboxPage.findCheckBox(2);
        objCheckboxPage.resetCheckBoxTo(2, CheckBoxStatus.CHECKED);
        objCheckboxPage.clickCheckBox(2);
        objLoginPage.wait(2);
        objCheckboxPage.assertCheckboxResult(2, CheckBoxStatus.UNCHECKED);
    }
}
