package tests;

import Pages.Login_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginSuccessTest {
    public  String LoginUrl = "login";
    WebDriver driverDotDash;
    Login_Page loginPage;
    @Before
    public void setUp() {
        loginPage=new Login_Page(driverDotDash);
        loginPage.setChrome();
        loginPage.setUrl(LoginUrl);

    }
    @Test
    public void loginToDotDash () {
        loginPage.waitForElement();
        loginPage.sendUserName();
        loginPage.sendPassword();
        loginPage.clickLoginBtn();
        loginPage.assertLogin();
    }
    @After
    public void tearDown() {
        loginPage.closeAllWindows();
    }
}
