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
        assertion.assertEquals(driver.getTitle(),"The Internet","Right url opened!!");

        LoginPage loginPage = new LoginPage(driver);    //Create object of LoginPage
        loginPage.setTxtusername(username); //Pass username
        loginPage.setTxtpassword(password); //Pass password
        loginPage.clkbtnLogin();        //Click on login button

        //Validate whether login is successful
        assertion.assertEquals(loginPage.txtmsgLogin(),"You logged into a secure area!\n" +
                "×","Login Successful!!");

        assertion.assertAll();



    }

}
