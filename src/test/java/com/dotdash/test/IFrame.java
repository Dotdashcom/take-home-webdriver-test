package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.IFramePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrame {

    private WebDriver chrome_driver = null;

    @BeforeClass
    void init() {
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("iframe");
    }

    @Test
    void able_to_input_text_to_iframe() {
        IFramePage iframe_page = new IFramePage(chrome_driver);
        iframe_page
                .input_text_in_Iframe("ABC")
                .verify_input_text();
    }

    @AfterClass
    void tear_down() {
        chrome_driver.close();
        chrome_driver.quit();
    }
}
