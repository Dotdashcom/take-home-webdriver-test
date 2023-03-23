package steps;

import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    public void signIn(String username, String password, String message) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        loginPage.checkMassage(message);
    }
}
