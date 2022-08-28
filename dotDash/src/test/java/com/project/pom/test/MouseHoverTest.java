package com.project.pom.test;

import com.project.pom.page.Login;
import com.project.pom.page.MouseHover;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class MouseHoverTest {

    private WebDriver driver;
    MouseHover mouseHover;

    @Before
    public void setUp(){
        mouseHover = new MouseHover(driver);
        driver = mouseHover.chromeDriverConnection();
        mouseHover.visit("/hovers");
    }

    @Test
    public void mouseHoverTest(){
        mouseHover.mouseHover();
    }

    @After
    public void end(){ driver.quit(); }
}
