package main;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Constants;

public class LoginFailure extends Constants {
    static String url = "http://localhost:7080/login";
    static String invalidUsername = "tom";
    static String invalidPassword = "123";

    @Test
    public static void testLoginFailure() {
        driver.get(url);
        LoginPage loginObj = new LoginPage(driver);
        loginObj.enterUsername(invalidUsername);
        loginObj.enterPassword(invalidPassword);
        loginObj.clickLogin();

        String actMessage = loginObj.getFlashMessage();
        sa.assertEquals(actMessage.contains("invalid"), true);

        sa.assertAll();
    }
}
