package tests;

import enums.Credentials;
import enums.Messages;
import enums.Pages;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.BrowserUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests extends TestBase {

    LoginPage loginPage;

    @Test(description = "Login Success")
    public void verifyLogin() {
        BrowserUtils.openPage(driver, Pages.LOGIN_PAGE);
        loginPage = new LoginPage();
        login(Credentials.MAIN.getUsername(), Credentials.MAIN.getPassword());
        BrowserUtils.waitUntilVisible(driver, loginPage.logoutBtn, Duration.ofSeconds(15));
        assertThat(loginPage.alertMSg.getText()).contains(Messages.SUCCESS.getMessage());
        assertThat(loginPage.alertMSg.getCssValue("background-color")).isEqualTo("rgba(93, 164, 35, 1)");
    }

    @Test(description = "Login Failure")
    public void verifyLoginFailure() {
        BrowserUtils.openPage(driver, Pages.LOGIN_PAGE);
        loginPage = new LoginPage();
        login("username1", "password2");
        BrowserUtils.waitUntilVisible(driver, loginPage.alertMSg, Duration.ofSeconds(15));
        assertThat(loginPage.alertMSg.getText()).contains(Messages.FAIL.getMessage());
        assertThat(loginPage.alertMSg.getCssValue("background-color")).isEqualTo("rgba(198, 15, 19, 1)");
        assertThat(loginPage.loginBtn.isDisplayed()).isTrue();
    }

    public void login(String username, String password) {
        BrowserUtils.waitUntilVisible(driver, loginPage.userName, Duration.ofSeconds(10));
        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginBtn.click();
    }
}
