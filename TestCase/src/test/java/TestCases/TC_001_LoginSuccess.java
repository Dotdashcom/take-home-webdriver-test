package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_001_LoginSuccess extends BaseClass
{
    @Test (priority=1) //Test Case for Login Success
    public void LoginTestPass()
    {
        //Launching login page URL
        driver.get(BaseUrl+"login");
        //Creating Object of POM for Login Page
        LoginPage lp=new LoginPage(driver);
        //Calling Methods for Username and Password from POM LoginPage
        lp.SetUserName(username);
        lp.SetPassword(password);
        //Clicking Login Method
        lp.ClickLogin();
        //Checking Assertions to make sure User has logged in
        Assert.assertTrue(driver.getPageSource().contains("You logged into a secure area!"));
    }

}
