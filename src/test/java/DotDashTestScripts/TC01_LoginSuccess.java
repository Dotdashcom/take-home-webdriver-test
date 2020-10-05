package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/* TestCase Description: Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
    */

public class TC01_LoginSuccess extends baseClass {

    @Test
    public void logintest()
    {
        //Launch url
        driver.get(baseURL+"/login");

        //Validate whether right page is opened
        SoftAssert assertion = new SoftAssert();
        if(driver.getTitle().equals("The Internet")) {
            assertion.assertTrue(true);
            System.out.println("Page opened correctly");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Wrong Page opened");

        }

        LoginPage loginPage = new LoginPage(driver);    //Create object of LoginPage
        loginPage.setTxtusername(username); //Pass username
        loginPage.setTxtpassword(password); //Pass password
        loginPage.clkbtnLogin();        //Click on login button

        //Validate whether login is successful
        if(loginPage.txtmsgLogin().contains("You logged into a secure area!"))
        {
            assertion.assertTrue(true);
            System.out.println("Login Successful!!!");

        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Login NOT Successful!!!");
        }

        assertion.assertAll();



    }

}
