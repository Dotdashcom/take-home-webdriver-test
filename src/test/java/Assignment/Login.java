package Assignment;

import Pages.LoginPage;
import Utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {


  public static  String username = "tomsmith";
  public static  String password = "SuperSecretPassword!";



    @Test
    public void testLoginFunctionWithValidCredentialsTest() {

        driver.get(baseUrl + "/login");

        LoginPage loginPage = new LoginPage(driver);




        loginPage.login(username,password);

        String  expectedHeaderMsg = "Welcome to the Secure Area. When you are done click logout below.";
        String  actualHeaderMsg = loginPage.headerFour.getText();

        Assert.assertEquals(actualHeaderMsg , expectedHeaderMsg , "login failed");



    }

    @Test
    public void testLoginFunctionWithInvalidPasswordTest() {
        driver.get(baseUrl + "/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login( username , password+"invalid");

        Assert.assertTrue(loginPage.failedLoginMsg.isDisplayed() , "Login was successful test FAILED!");

        String expectedHeaderMsg = "Your password is invalid!";

        String actualHeaderMsg = loginPage.failedLoginMsg.getText();


        Assert.assertEquals(actualHeaderMsg , expectedHeaderMsg , "failed login message incorrect");

    }

    @Test
    public void testLoginFunctionWithInvalidUsernameTest(){
        driver.get(baseUrl + "/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login( username +"invalid" , password);

        Assert.assertTrue(loginPage.failedLoginMsg.isDisplayed() , "Login was successful test FAILED!");

        String expectedHeaderMsg = "Your username is invalid!";

        String actualHeaderMsg = loginPage.failedLoginMsg.getText();


        Assert.assertEquals(actualHeaderMsg , expectedHeaderMsg , "failed login message incorrect");

    }
    @Test
    public void testLoginFunctionWithInvalidCredentialsTest(){

        driver.get(baseUrl + "/login");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login( username +"invalid" , password+"invalid");

        Assert.assertTrue(loginPage.failedLoginMsg.isDisplayed() , "Login was successful test FAILED!");

        String expectedHeaderMsg = "Your username is invalid!";

        String actualHeaderMsg = loginPage.failedLoginMsg.getText();


        Assert.assertEquals(actualHeaderMsg , expectedHeaderMsg , "failed login message incorrect");

    }
}