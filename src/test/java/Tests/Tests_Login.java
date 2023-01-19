package Tests;

import Baseclass.BaseClass;

import Pages.Login_Page;
import org.testng.annotations.Test;

public class Tests_Login extends BaseClass {

    @Test
    public void T001_Login_Success_Testing() {
        Login_Page login_page = new Login_Page(driver);
        login_page.GoToLoginPage();
        login_page.Perform_Successful_Login();
    }
    @Test
    public void T002_Login_Failing_Testing() {
        Login_Page login_page = new Login_Page(driver);
        login_page.GoToLoginPage();
        login_page.Perform_Failing_Login();
    }


}
