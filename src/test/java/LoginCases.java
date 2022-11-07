import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginCases extends Hooks {

    @Test(dataProvider = "Login")
    public  void Login(String user,String pass,String message){
        App.homePage.clickOptionFromMenu(HomeOptions.Login.getOption());
        App.loginPage.Login(user,pass);
        Assert.assertTrue(App.loginPage.ValidateLoginStatus(message));
    }
}
