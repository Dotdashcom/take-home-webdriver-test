package com.dotdash.test;

import com.dotdash.flow.LoginFlow;
import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
    private WebDriver chrome_driver = null;

    @BeforeClass
    void init() {
        Webdriver web_driver = new Webdriver();
        chrome_driver = web_driver.get_chrome_driver();
        web_driver.open_page("login");
    }

    @Test
    void login_invalid_creds() {
        /*
         * This is the 1st pattern where we use page object directly here
         * */
        LoginPage login_page = new LoginPage(chrome_driver);
        login_page
                .input_username("abc")
                .input_password("abc")
                .click_on_login_btn();
        login_page.verify_wrong_credentials_msg();
    }

    @Test
    void login_valid_creds() {
        /*
         * This is the 2nd pattern where we abstract business Logic in a business flow and reuse
         * We will not use page object directly here in the test, just the business abstraction
         * */
        LoginFlow login_flow = new LoginFlow(chrome_driver, "tomsmith", "SuperSecretPassword!");
        login_flow.login();
        login_flow.verify_correct_credentials_msg();
    }

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }

}


