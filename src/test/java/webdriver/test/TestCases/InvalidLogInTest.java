package webdriver.test.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import webdriver.test.Pages.LogInPage;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class InvalidLogInTest {

    private WebDriver driver;
    private LogInPage loginPage;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        loginPage = new LogInPage(driver);

    }

    @Test
    public void LoginFailureUserName(){


        loginPage.enterUserName("smith");
        loginPage.enterPassWord("SuperSecretPassword!");

        loginPage.ClickLoginButton();


        assertTrue(loginPage.getFlashMessage().contains("Your username is invalid!"));

        System.out.println(">>>> Error Message Displayed When Username is invalid ");


    }


    @Test
    public void LoginFailurePassword(){

        loginPage.enterUserName("tomsmith");
        loginPage.enterPassWord("Super");

        loginPage.ClickLoginButton();

        assertTrue(loginPage.getFlashMessage().contains("Your password is invalid!"));

        System.out.println(">>>> Error Message Displayed When Password is invalid ");

        driver.navigate().refresh();

    }


    @AfterClass
    public void TearDown() {

        driver.quit();

    }

}
