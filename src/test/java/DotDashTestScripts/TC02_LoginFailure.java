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
        if (driver.getTitle().equals("The Internet")) {
            assertion.assertTrue(true);
            System.out.println("Page opened correctly");
        } else {
            assertion.assertTrue(false);
            System.out.println("Wrong Page opened");
        }

        LoginPage loginPage = new LoginPage(driver);    //Create object of LoginPage
        loginPage.setTxtusername(username); //Pass username
        loginPage.setTxtpassword(password); //Pass password
        loginPage.clkbtnLogin();        //Click on login button

        //Validate whether login is successful
        if (loginPage.txtmsgLogin().contains("You logged into a secure area!")) {
            assertion.assertTrue(false);
            System.out.println("Test Failed: Login Successful with wrong credentials!!!");

        } else {
            assertion.assertTrue(true);
            System.out.println("Test Passed: Login NOT Successful!!!");
            System.out.println("Reason: " +loginPage.txtmsgLogin());

        }

        assertion.assertAll();
    }

    @DataProvider(name="InvalidData")
    public Object[][] getData () throws IOException {
        String path = System.getProperty("user.dir")+"\\src\\test\\java\\DotDashTestData\\TestData.xlsx";
        return XLUtils.getData(path,"Invalid");

    }

}
