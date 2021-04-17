package HomeWork;

import PageObjectClasses.LoginPageObjects;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Loginpage extends Base{

    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/login";

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void logInSuccess() throws IOException {


        LoginPageObjects lp = new LoginPageObjects(driver);
        lp.getUsername().sendKeys("tomsmith");
        lp.getPassword().sendKeys("SuperSecretPassword!");
        lp.getLoginButton().click();
        Assert.assertTrue(lp.getConfirmation().getText().equals("Welcome to the Secure Area. When you are done click logout below."));
    }

    @Test(dependsOnMethods = "logInSuccess")
    public void logInFail() throws IOException {


        LoginPageObjects lp = new LoginPageObjects(driver);
        lp.getUsername().sendKeys("tomsmit");
        lp.getPassword().sendKeys("SuperSecretPassword");
        lp.getLoginButton().click();
        Assert.assertTrue(lp.getFailureConfirmation().getText().contains("Your username is invalid!"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
