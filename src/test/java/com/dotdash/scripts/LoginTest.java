package com.dotdash.scripts;

import com.dotdash.pages.Login;
import com.dotdash.pages.LoginSuccess;
import org.junit.Test;

import static com.dotdash.utils.RandomDataGenerator.getRandomEmail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

public class LoginTest extends BaseWebTest<Login>{

    private final String VALID_USERNAME = "tomsmith";
    private final String VALID_PASSWORD = "SuperSecretPassword!";

    @Test
    public void loginSuccessful() {
        LoginSuccess loginSuccessPage = getInitialPage()
                .enterUsername(VALID_USERNAME)
                .enterPassword(VALID_PASSWORD)
                .login();

        checkThat("Login Success message is visible", loginSuccessPage.isSuccessMessageVisible(), is(true));
    }

    @Test
    public void loginWithInvalidCredentials() {
        String randomString = getRandomEmail();

        Login loginPage = getInitialPage()
                .enterUsername(randomString)
                .enterPassword(VALID_PASSWORD)
                .loginInvalid();

        checkThat("Invalid username message is displayed", loginPage.getInvalidCredentialsMessage(), containsString("username is invalid"));

        loginPage.enterUsername(VALID_USERNAME).enterPassword(randomString).loginInvalid();

        checkThat("Invalid password message is displayed", loginPage.getInvalidCredentialsMessage(), containsString("password is invalid"));
    }
}
