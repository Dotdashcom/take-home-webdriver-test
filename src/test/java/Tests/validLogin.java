package Tests;

import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class validLogin {
    String baseURL="http://localhost:7080";
    @Test
    public void loginValid(){
        LoginPage loginPage=new LoginPage();

        Driver.getDriver().get(baseURL+"/login");

        loginPage.username.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.submit.click();
        assertTrue(loginPage.validLoginMessage.isDisplayed());

    }
}
