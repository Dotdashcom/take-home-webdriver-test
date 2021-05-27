package com.dotdash.stepDeffinition;

import com.dotdash.pages.Login_Page;
import com.dotdash.utillities.ConfigurationReader;
import com.dotdash.utillities.Driver;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginTest {

    @Before // With Before method I'm setting up url and this way when i start test execution will go to login page
    public void setup(){
        Driver.getDriver().get(url);

    }

   @After // With After method after the test execution driver will close itself.
   public void teardown(){
        Driver.closeDriver();
    }



    Login_Page login = new Login_Page(); // in here I created Login page object and that way i can use it in this class


    // I created configReader class that way i can get data from Config.Properties.
    // In config.prop i have stored data key, value format.
    // This way if i have to change some data i can go to config.prop and change it there and that way I don't have to change it everywhere i used that data

    String url = ConfigurationReader.getProperty("dotdashUrl");
    String username = ConfigurationReader.getProperty("username");
    String password = ConfigurationReader.getProperty("userpassword");



    @Test
    public void login_Test_With_Valid_Credentials() {

       // here filling username box and password box then click login button
        login.usernameBox.sendKeys(username);
        login.passwordBox.sendKeys(password);
        login.loginButton.click();

       //getting expected and actual messages.
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = login.loginSuccessful.getText();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.textToBePresentInElement(login.loginSuccessful,actualMessage));

        //here I'm comparing message after successfully login with actual login message.
        Assert.assertTrue(actualMessage.contains(expectedMessage));


    }

    @Test
    public void logout_Test() {

// In here I'm checking after I logged in then logout successfully.
        login.usernameBox.sendKeys(username);
        login.passwordBox.sendKeys(password);
        login.loginButton.click();
        login.logoutButton.click();

        String expectedMessage = "You logged out of the secure area!";
        String actualMessage = login.logoutSuccess.getText();

        // Checking actual message with expected message
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void login_Test_With_Invalid_Username() {

        // In this test i'm checking wrong userName and correct password
        login.usernameBox.sendKeys("tomsmith1");
        login.passwordBox.sendKeys("SuperSecretPassword!");
        login.loginButton.click();

        String expectedMessage = "Your username is invalid!";
        String actualMessage = login.invalidUsernameWarning.getText();


        // Checking generated message for invalid user and valid password
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void login_Test_With_Invalid_Password() {

       //In here I'm checking correct user name and invalid password.
        login.usernameBox.sendKeys("tomsmith");
        login.passwordBox.sendKeys("SuperSecret12345");
        login.loginButton.click();


        String expectedMessage = "Your password is invalid!";
        String actualMessage = login.invalidPasswordWarning.getText();

        //Checking generated message for invalid password with correct user name
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void login_Test_With_Invalid_Username_And_Password() {

      //In this test i checked invalid username and password
        login.usernameBox.sendKeys("1tomsmith");
        login.passwordBox.sendKeys("SuperSecretPassword123");
        login.loginButton.click();

        String expectedMessage = "Your username is invalid!";
        String actualMessage = login.invalidUsernameWarning.getText();

        //Checking generated message for invalid user name and password
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }


}