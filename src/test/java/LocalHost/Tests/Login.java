package LocalHost.Tests;

import LocalHost.Pages.LoginPage;
import static LocalHost.Utilities.BrowserUtils.*;
import org.testng.annotations.Test;

public class Login extends TestingBase {


LoginPage login;
    @Test(groups = {"Login"})
    public void loginSuccess() {
    login = new LoginPage();
        waitForPageToLoad(5);
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        login.login(username,password);
        login.VerifySuccessMessage();
    }

    @Test(groups = {"Login"})
    public void loginFail(){
  login = new LoginPage();
        waitForPageToLoad(5);
        String username= "Somethingrandom";
        String password="NotSoSecret";
        login.login(username,password);
        login.VerifyErrorMessage();
    }
}
