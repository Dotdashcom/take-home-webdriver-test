package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.LoginPage;
import com.example.testautomation_dotdash.pages.SecurePage;
import org.junit.Test;

public class LoginTest extends BaseTest {


    public LoginTest() {
        super();
    }

    @Test
    public void LoginSuccessfull(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUsername(prop.getProperty("username"));
        loginPage.fillPassword(prop.getProperty("password"));
        loginPage.clickLoginBtn();

        SecurePage securePage = new SecurePage(driver);

        securePage.verifyBannerSuccessfullMessage("You logged into a secure area!\n" + "×");
        securePage.verifyLogoutBtnIsEnabled();


    }

    @Test
    public void LoginFailure(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUsername(prop.getProperty("usernameInvalid"));
        loginPage.fillPassword(prop.getProperty("passwordInvalid"));
        loginPage.clickLoginBtn();

        loginPage.verifyBannerErrorMessage("Your username is invalid!\n" + "×");
        loginPage.verifyLoginBtnIsEnabled();

    }

}
