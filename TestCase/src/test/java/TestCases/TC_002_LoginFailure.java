package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_002_LoginFailure extends BaseClass
{
    @Test (priority=2) //Test Case for Login Failure
    public void LoginTestFail()
    {
        //Launching login page URL
        driver.get(BaseUrl+"login");
        //Creating Object of POM for Login Page
        LoginPage lp=new LoginPage(driver);
        //Calling Methods for Username and Password from POM LoginPage for Wrong Credentials
        lp.SetUserName(wrngUname);
        lp.SetPassword(wrngPwd);
        //Clicking Login Method
        lp.ClickLogin();
        //assertions to check Login failed for incorrect user and password.
        Assert.assertTrue(driver.getPageSource().contains("You logged into a secure area!"));
    }

}
