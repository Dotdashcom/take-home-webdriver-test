package testsJunit;


import junit.framework.Assert;
import org.junit.Test;
import pages.LoginPage;
import utils.Driver;


public class LoginP extends BaseClass  {
    LoginPage loginpage = new LoginPage();

    //I am on the homepage
    //I enter username and password

    @Test
    public void i_am_on_the_homepage() {
        Driver.getDriver().get("http://localhost:7080/login");
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        loginpage.userid.sendKeys(username);
        loginpage.userpassword.sendKeys(password);
        loginpage.loginbutton.click();

        String expectedtextsuccess = "Welcome to the Secure Area. When you are done click logout below.";
        String actualtextsuccess = loginpage.actualtext.getText();
        Assert.assertEquals(expectedtextsuccess, actualtextsuccess);
        System.out.println(actualtextsuccess);
    }


    //I enter invalid  username and password
    //I varify  message for invalid log in entry
    @Test
    public void i_enter_invalid_username_and_password() {
        Driver.getDriver().get("http://localhost:7080/login");
        String username = "tomhanks";
        String password = "SuperSecretPasswordInvalid!";
        loginpage.userid.sendKeys(username);
        loginpage.userpassword.sendKeys(password);
        loginpage.loginbutton.click();

        String expectedtextfail = "Your username is invalid!";
        String actualtextfail = loginpage.actualtextforfailcase.getText();
        if (actualtextfail.contains(expectedtextfail)) {
            actualtextfail = expectedtextfail;
        }
        Assert.assertEquals(expectedtextfail, actualtextfail);

        System.out.println(actualtextfail);

    }


}
