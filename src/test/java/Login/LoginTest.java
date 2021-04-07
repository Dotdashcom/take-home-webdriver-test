package Login;
import Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.TestBase;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends TestBase {

    @BeforeClass
    public void loginUrl(){
        driver.get(TestBase.BASEURL.concat("/login"));
    }
    @Test()
    public void positiveloginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();
        assertTrue(new LoginPage().loginedInmessage.getText().contains("You logged into a secure area!"));

    }
    @Test()
    public void negetiveloginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys("test");
        loginPage.password.sendKeys("test");
        loginPage.loginButton.click();
        assertTrue(new LoginPage().loginedInmessage.getText().contains("Your username is invalid!"));

    }
}