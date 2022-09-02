package Tests;

import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvalidLogin {
    String baseURL="http://localhost:7080";
    @Test
    public void loginInvalid(){
        LoginPage loginPage=new LoginPage();

        Driver.getDriver().get(baseURL+"/login");

        loginPage.username.sendKeys("wrong");
        loginPage.password.sendKeys("wrong");
        loginPage.submit.click();
        assertTrue(loginPage.invalidLoginMessage.isDisplayed());

    }
}
