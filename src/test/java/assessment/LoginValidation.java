package assessment;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import util.Driver;

public class LoginValidation extends Driver {

    LoginPage page = new LoginPage(Driver.getDriver());

    String expectedHeaderMsg;

    String actualHeaderMsg;

    @Test
    public void login_success() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        Driver.getDriver().get("http://localhost:7080/login");
        page.login(username , password);

        expectedHeaderMsg = "Welcome to the Secure Area. When you are done click logout below.";
        actualHeaderMsg = page.headerFour.getText();

        Assert.assertEquals(actualHeaderMsg , expectedHeaderMsg , "login failed");
    }

    @Test
    public void login_failure_invalid_username_message() {
        String invalid= "invalid";

        Driver.getDriver().get("http://localhost:7080/login");
        page.login(invalid , invalid);

        Assert.assertTrue(page.failedLoginMsg.isDisplayed() , "test failed -> login was successfull");

        expectedHeaderMsg = "Your username is invalid!";

        actualHeaderMsg = page.failedLoginMsg.getText();
        actualHeaderMsg = page.parseFailedLoginMessage(actualHeaderMsg);

        Assert.assertEquals(actualHeaderMsg , expectedHeaderMsg , "failed login message incorrect");
    }

    @Test
    public void login_failure_invalid_password_message() {
        String invalid= "invalid";

        Driver.getDriver().get("http://localhost:7080/login");
        page.login("tomsmith" , invalid);

        Assert.assertTrue(page.failedLoginMsg.isDisplayed() , "test failed -> login was successfull");

        expectedHeaderMsg = "Your password is invalid!";

        actualHeaderMsg = page.failedLoginMsg.getText();
        actualHeaderMsg = page.parseFailedLoginMessage(actualHeaderMsg);

        Assert.assertEquals(actualHeaderMsg , expectedHeaderMsg , "failed login message incorrect");
    }
}