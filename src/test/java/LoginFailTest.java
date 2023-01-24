import BaseClass.BaseClass;
import PageClass.LoginFail;
import PageClass.NewPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFailTest extends BaseClass {

    LoginFail LF;
    NewPage newlogin;

    public LoginFailTest(){
        super();
    }
    @BeforeMethod
    public void SetUP() {
        initialization();
        LF = new LoginFail();
        newlogin = new NewPage();
    }

    @Test(priority = 1)
    public void loginFailTest(){
        newlogin = LF.logindetails(prop.getProperty("username"), prop.getProperty("WPWD"));
           boolean errrormsg = LF.VerifyError();
           Assert.assertTrue(errrormsg);
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
