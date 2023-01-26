import BaseClass.BaseClass;
import PageClass.LoginSuccess;
import PageClass.NewPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginSuccessTest extends BaseClass {
        LoginSuccess login;
        NewPage loginpage;

    public LoginSuccessTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        login = new LoginSuccess();
        loginpage= new NewPage();
    }
    @Test(priority = 1)
    public void loginTest()  {
        loginpage = login.userdetails(prop.getProperty("username"), prop.getProperty("password"));
        String act = "http://localhost:7080/secure";
        String exp = "http://localhost:7080/secure";
        Assert.assertEquals(act,exp);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
