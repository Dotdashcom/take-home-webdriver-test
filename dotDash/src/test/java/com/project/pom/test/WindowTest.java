package com.project.pom.test;

import com.project.pom.page.Login;
import com.project.pom.page.Window;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class WindowTest {

    private WebDriver driver;
    Window window;

    @Before
    public void setUp(){
        window = new Window(driver);
        driver = window.chromeDriverConnection();
        window.visit("/windows");
    }

    @Test
    public void windowNewTest(){
        assertEquals("New Window" , window.newWindow());
    }

    @After
    public void end(){ driver.quit(); }
}
