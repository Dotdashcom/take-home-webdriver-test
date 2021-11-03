import constants.CheckBoxStatus;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import pages.ContextMenuPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class Setup {
    WebDriver driver;
    LoginPage objLoginPage;
    CheckboxPage objCheckboxPage;
    ContextMenuPage objContextMenuPage;

    @BeforeTest
    public void setup() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("http://localhost:7080");
    }

    @Test
    public void test_login_success() {
        this.objLoginPage = new LoginPage(this.driver);
        this.objLoginPage.enterUsername("tomsmith");
        this.objLoginPage.enterPassword("SuperSecretPassword!");
        this.objLoginPage.clickOnLoginButton();
        this.objLoginPage.wait(1);
        this.objLoginPage.softAssertLoginResult(false);
    }

    @Test
    public void test_login_failure() {
        this.objLoginPage = new LoginPage(this.driver);
        this.objLoginPage.enterUsername("tomsmitH");
        this.objLoginPage.enterPassword("supersecretpassword!");
        this.objLoginPage.clickOnLoginButton();
        this.objLoginPage.wait(1);
        this.objLoginPage.softAssertLoginResult(true);
    }

    @Test
    public void test_check_checkbox() {
        this.objCheckboxPage = new CheckboxPage(this.driver);
        this.objCheckboxPage.findCheckBox(1);
        this.objCheckboxPage.resetCheckBoxTo(1, CheckBoxStatus.UNCHECKED);
        this.objCheckboxPage.clickCheckBox(1);
        this.objCheckboxPage.wait(1);
        this.objCheckboxPage.assertCheckboxResult(1, CheckBoxStatus.CHECKED);
    }

    @Test
    public void test_uncheck_checkbox() {
        this.objCheckboxPage = new CheckboxPage(this.driver);
        this.objCheckboxPage.findCheckBox(2);
        this.objCheckboxPage.resetCheckBoxTo(2, CheckBoxStatus.CHECKED);
        this.objCheckboxPage.clickCheckBox(2);
        this.objCheckboxPage.wait(2);
        this.objCheckboxPage.assertCheckboxResult(2, CheckBoxStatus.UNCHECKED);
    }

    @Test
    public void test_right_click_context_menu() {
        this.objContextMenuPage = new ContextMenuPage(this.driver);
        this.objContextMenuPage.wait(1);
        this.objContextMenuPage.rightClickContextMenu();
        this.objContextMenuPage.assertAlertText("You selected a context menu");
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
