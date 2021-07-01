package webdriver.test.TestCases;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import webdriver.test.Pages.LogInPage;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class LogInTest
{

    private WebDriver driver;
    private LogInPage loginPage;

    @BeforeClass
    public void Setup() throws IOException{

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().deleteAllCookies();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        loginPage = new LogInPage(driver);

    }



    @Test
    public void LoginSuccess(){


        loginPage.enterUserName("tomsmith");

        loginPage.enterPassWord("SuperSecretPassword!");

        loginPage.ClickLoginButton();

        assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area!"));

        System.out.println(">>>> Successfully Login ");

        driver.close();
    }



    @AfterClass
    public void TearDown(){

        driver.quit();

    }


}
