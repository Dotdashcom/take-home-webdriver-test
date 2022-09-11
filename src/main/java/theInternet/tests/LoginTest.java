package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.LoginPage;

public class LoginTest extends TestBase {



//    @Test
//    public void PositiveLoginTest() throws InterruptedException {
//        driver.get(driver.getCurrentUrl()+"/login");
//
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.sendInfo("tomsmith","SuperSecretPassword");
//
//    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        driver.get(driver.getCurrentUrl()+"/login");

        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInfo("tomsmith","Password");
        loginPage.sendWrongInfo();
    }


}
