package com.project.pom.test;

import com.project.pom.page.FloatingMenu;
import com.project.pom.page.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FloatingMenuTest {

    private WebDriver driver;
    FloatingMenu floatingMenu;

    @Before
    public void setUp(){
        floatingMenu = new FloatingMenu(driver);
        driver = floatingMenu.chromeDriverConnection();
        floatingMenu.visit("/floating_menu");
    }

    @Test
    public void floatingMenuTest() throws InterruptedException {
        floatingMenu.scrollDown();
        Thread.sleep(2000);
        assertTrue(floatingMenu.mainMenu());
    }

    @After
    public void end(){ driver.quit(); }
}
