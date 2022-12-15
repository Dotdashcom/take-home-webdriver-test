package Test;

import Main.LoginPage;
import Utilities.DriverHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest {

    LoginPage loginPage =new LoginPage();

    @Test
    public void loginSuccess (){

        DriverHelper.getDriver().get("http://localhost:7080/login");

        DriverHelper.getDriver().manage().window().maximize();

        loginPage.UserName.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.loginButton.click();

        System.out.println(loginPage.messages.getText());

        Assert.assertEquals(loginPage.messages.getText(),"You logged into a secure area!\n" +
                "×");

        DriverHelper.closeDriver();

    }


    @Test
    public void loginFailure_wrongUserName (){

        DriverHelper.getDriver().get("http://localhost:7080/login");

        DriverHelper.getDriver().manage().window().maximize();

        loginPage.UserName.sendKeys("tomSmith");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.loginButton.click();

        System.out.println(loginPage.messages.getText());

        Assert.assertEquals(loginPage.messages.getText(),"Your username is invalid!\n" +
                "×");

        DriverHelper.closeDriver();
    }

    @Test
    public void loginFailure2_wrongPassword (){

        DriverHelper.getDriver().get("http://localhost:7080/login");

        DriverHelper.getDriver().manage().window().maximize();

        loginPage.UserName.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!!!");
        loginPage.loginButton.click();

        Assert.assertEquals(loginPage.messages.getText(),"Your username is invalid!\n" +
                "×");

        DriverHelper.closeDriver();

    }
}
