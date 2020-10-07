package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.LoginPage;
import DotDashUtilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
/* Testcase Description: Login Failure: http://localhost:7080/login Login fail invalid creadentials
 */
public class TC02_LoginFailure extends baseClass {

    @Test(dataProvider = "InvalidData")
    public void loginfailtest(String username, String password) {
        //Launch url
        driver.get(baseURL + "/login");

        //Validate whether right page is opened
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(driver.getTitle(),"The Internet","Right url opened!!");

        LoginPage loginPage = new LoginPage(driver);    //Create object of LoginPage
        loginPage.setTxtusername(username); //Pass username
        loginPage.setTxtpassword(password); //Pass password
        loginPage.clkbtnLogin();        //Click on login button

        //Validate whether login is successful
        assertion.assertNotEquals(loginPage.txtmsgLogin(),"You logged into a secure area!\n" +
                "×","Test Passed!! Login failed due to wrong credentials!!");
        assertion.assertAll();
    }

    @DataProvider(name="InvalidData")
    public Object[][] getData () throws IOException {
        String path = System.getProperty("user.dir")+"\\src\\test\\java\\DotDashTestData\\TestData.xlsx";
        return XLUtils.getData(path,"Invalid");

    }

}
