import framework.Pages.HomePage;
import framework.Pages.LoginPage;
import framework.Pages.SecureAreaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class LoginTest extends WebDriverWrapper {


    @Test
    public void loginToApp(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickLogin();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("tomsmith","SuperSecretPassword!");

        SecureAreaPage secureAreaPage = PageFactory.initElements(driver, SecureAreaPage.class);
        secureAreaPage.verifyLoginSuccessful();
        secureAreaPage.logout();

    }

    @Test
    public void invalidCredentials(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickLogin();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("tomsmith","WrongPassword!");
        loginPage.verifyLoginFailure();
    }
}
