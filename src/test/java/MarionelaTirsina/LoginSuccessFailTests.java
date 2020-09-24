package MarionelaTirsina;

import MarionelaTirsina.pages.LogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class LoginSuccessFailTests {
    /**
     * //Login Success: http://localhost:7080/login
     * credentials: tomsmith/SuperSecretPassword!
     */
    LogIn logIn=new LogIn();

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/login");
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }




    @Test
    public void loginSuccessTest(){

        WebElement usernameBox = logIn.username;
        WebElement passwordBox = logIn.password;
        WebElement loginButton = logIn.loginButton;

        usernameBox.sendKeys(ConfigurationReader.getProperty("username"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();

        String expectedMessage = "You logged into a secure area!";

        WebElement messageForm = logIn.messageBox;
        String actualMessage = messageForm.getText();


        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }


    /**
     * Login Failure: http://localhost:7080/login Login fail invalid creadentials
     */
    @Test
    public void loginFailureTest(){

        WebElement usernameBox = logIn.username;
        WebElement passwordBox =logIn.password;
        WebElement loginButton = logIn.loginButton;
        usernameBox.sendKeys("wrongUsername");
        passwordBox.sendKeys("wrongPassword!");
        loginButton.click();

        String expectedMessage = "Your username is invalid!";
        WebElement message = logIn.wrongCredentialsMessage;
        String actualMessage = message.getText();


        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

    }
}
