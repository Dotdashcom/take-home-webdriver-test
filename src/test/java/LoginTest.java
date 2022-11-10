import Pages.LoginPage;
import Utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    LoginPage loginPage =new LoginPage();

    @Test
    public void loginSuccess (){

        Driver.getDriver().get("http://localhost:7080/login");

        Driver.getDriver().manage().window().maximize();

        loginPage.UserName.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.loginButton.click();

        System.out.println(loginPage.messages.getText());

        Assert.assertEquals(loginPage.messages.getText(),"You logged into a secure area!\n" +
                "×");

        Driver.closeDriver();

    }


    @Test
    public void loginFailure_wrongUserName (){

        Driver.getDriver().get("http://localhost:7080/login");

        Driver.getDriver().manage().window().maximize();

        loginPage.UserName.sendKeys("tomSmith");
        loginPage.password.sendKeys("SuperSecretPassword!");
        loginPage.loginButton.click();

        System.out.println(loginPage.messages.getText());

        Assert.assertEquals(loginPage.messages.getText(),"Your username is invalid!\n" +
                "×");

        Driver.closeDriver();
    }

    @Test
    public void loginFailure2_wrongPassword (){

        Driver.getDriver().get("http://localhost:7080/login");

        Driver.getDriver().manage().window().maximize();

        loginPage.UserName.sendKeys("tomsmith");
        loginPage.password.sendKeys("SuperSecretPassword!!!");
        loginPage.loginButton.click();

        Assert.assertEquals(loginPage.messages.getText(),"Your username is invalid!\n" +
                "×");

        Driver.closeDriver();

    }


}