package Tests;

import Baseclass.BaseClass;

import Pages.LoginPage;
import org.testng.annotations.Test;

public class TestsLogin extends BaseClass {

    @Test
    public void T001_Login_Success_Testing() {
        LoginPage login_page = new LoginPage(driver);
        login_page.GoToLoginPage();
        login_page.Perform_Successful_Login();
    }
    @Test
    public void T002_Login_Failing_Testing() {
        LoginPage login_page = new LoginPage(driver);
        login_page.GoToLoginPage();
        login_page.Perform_Failing_Login();
    }


}
