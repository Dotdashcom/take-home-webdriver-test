package tests;

import Pages.Login_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFailureTest {
    WebDriver driverDotDash;
    Login_Page loginFailed;
    public  String LoginUrl = "login";
    @Before
    public void setUp() {
        loginFailed=new Login_Page(driverDotDash);
        loginFailed.setChrome();
        loginFailed.setUrl(LoginUrl);
    }
    @Test
    public void failedloginToDotDash () {
        loginFailed.waitForElement();
        loginFailed.sendUserName();
        loginFailed.sendWrongPassword();
        loginFailed.clickLoginBtn();
        loginFailed.assertWrongLogin();
    }
    @After
    public void tearDown() {
       loginFailed.closeAllWindows();
    }
}
