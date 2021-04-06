package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        WebElement ErrMsg=driver.findElement(By.id("flash"));
        String ErrTxt=ErrMsg.getText();
        System.out.println(ErrTxt);

        //assertions to check Login failed for incorrect user and password.
        if(driver.getPageSource().contains("Your username is invalid!"))
        {
            Assert.assertTrue(true);
            System.out.println("Your Login Failed because of wrong user name or password");
        }
        else
        {
        Assert.assertTrue(false);
        }

}
}
