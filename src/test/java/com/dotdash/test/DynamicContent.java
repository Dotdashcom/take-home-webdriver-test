package com.dotdash.test;

import com.dotdash.helper.Webdriver;
import com.dotdash.pageobject.DynamicContentPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicContent {
    private WebDriver chrome_driver = null;

    @BeforeClass
    void init(){
        Webdriver driver = new Webdriver();
        chrome_driver = driver.get_chrome_driver();
        driver.open_page("dynamic_content");
    }

    @Test
    void make_sure_dynamic_content_change(){
        final int TIME_TO_REFRESH = 3;
        DynamicContentPage dynamic_content_page = new DynamicContentPage(chrome_driver);
        dynamic_content_page.verify_content_change_after_refresh(TIME_TO_REFRESH);
    }

    @AfterClass
    void tear_down(){
        chrome_driver.close();
        chrome_driver.quit();
    }

}
