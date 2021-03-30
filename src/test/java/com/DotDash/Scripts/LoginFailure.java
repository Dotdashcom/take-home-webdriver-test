package com.DotDash.Scripts;

import com.DotDash.Pages.LoginPage;
import com.DotDash.Utilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import com.DotDash.BasePage.basePage;
public class LoginFailure extends basePage {

    @Test(dataProvider = "InvalidData")
    public void loginfailtest(String username, String password) {
        driver.get(baseURL + "/login");

        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(driver.getTitle(), "The Internet", "Right url opened!!");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setTxtusername(username);
        loginPage.setTxtpassword(password);
        loginPage.clkbtnLogin();

        assertion.assertNotEquals(loginPage.txtmsgLogin(), "You logged into a secure area!\n" +
                "×", "Test Passed!! Login failed due to wrong credentials!!");
        assertion.assertAll();
    }

    @DataProvider(name = "InvalidData")
    public Object[][] getData() throws IOException {

        String path = "TestData.xlsx";

        return XLUtils.getData(path, "Invalid");

    }

}
