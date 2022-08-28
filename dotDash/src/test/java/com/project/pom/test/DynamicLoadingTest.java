package com.project.pom.test;

import com.project.pom.page.DynamicLoading;
import com.project.pom.page.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DynamicLoadingTest {

    private WebDriver driver;
    DynamicLoading dynamicLoading;

    @Before
    public void setUp(){
        dynamicLoading = new DynamicLoading(driver);
        driver = dynamicLoading.chromeDriverConnection();
        dynamicLoading.visit("/dynamic_loading/2");
    }

    @Test
    public void dynamicLoadingTest() throws InterruptedException {
        dynamicLoading.dynamicLoading();
        assertTrue("true", dynamicLoading.compareFinishMessage());
    }

    @After
    public void end(){ driver.quit(); }
}
