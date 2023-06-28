//Tests:
//        Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
//        Login Failure: http://localhost:7080/login Login fail invalid creadentials


package alltests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
      String driverPath =  "./src/drivers/chromedriver.exe";
//    String driverPath = ("user.dir" + "/drivers/chromedriver.exe");
    public WebDriver driver;

    public String baseUrl  = "http://localhost:7080/";

    @BeforeMethod
    public void launchBrowser() {
        System.out.println("launching browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver= new ChromeDriver();
    }

    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }

    // Test is able to login successfully
    @Test(priority = 0)
    public void loginSuccess() {
        System.out.println("\n Running loginSuccess test method");

        // open login/registration page
        driver.get(baseUrl +"login");

        LoginPom loginpom = new LoginPom(driver);

        // enter valid data
        loginpom.loginName("tomsmith");
        loginpom.loginPass("SuperSecretPassword!");
        loginpom.submitLogin();

        // assertion to make sure User has logged in
        Assert.assertTrue(loginpom.assetLogin().contains("You logged into a secure area!"));
        loginpom.logoutClick();
    }

    // Test not able to login with wrong credentials
    @Test(priority = 1)
    public void loginFailure() {
        System.out.println("Running loginFailure test method");

        driver.get(baseUrl +"login");

        LoginPom loginpom = new LoginPom(driver);

        // enter incorrect user and password
        loginpom.loginName("NotTom");
        loginpom.loginPass("PasswordWrong");
        loginpom.submitLogin();
        // assertion to check Login failed
        Assert.assertTrue(loginpom.getErrorName().contains("Your username is invalid!"));

        // enter incorrect - username
        // and valid pass
        loginpom.loginName(("tom"));
        loginpom.loginPass("SuperSecretPassword!");
        loginpom.submitLogin();
        // assertion to check Login failed
        Assert.assertTrue(loginpom.getErrorName().contains("Your username is invalid!"));

        // enter incorrect - password
        // and valid username
        loginpom.loginName(("tomsmith"));
        loginpom.loginPass("Password");
        loginpom.submitLogin();
        // assertion to check Login failed
        Assert.assertTrue(loginpom.getErrorPass().contains("Your password is invalid!"));

        // enter one blank character for username and password
        loginpom.loginName((" "));
        loginpom.loginPass(" ");
        loginpom.submitLogin();
        // assertion to check Login failed
        Assert.assertTrue(loginpom.getErrorName().contains("Your username is invalid!"));

        }

}
