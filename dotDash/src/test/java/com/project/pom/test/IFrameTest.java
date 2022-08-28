package com.project.pom.test;

import com.project.pom.page.IFrame;
import com.project.pom.page.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class IFrameTest {

    private WebDriver driver;
    IFrame iFrame;

    @Before
    public void setUp(){
        iFrame = new IFrame(driver);
        driver = iFrame.chromeDriverConnection();
        iFrame.visit("/iframe");
    }

    @Test
    public void iFrameTest() throws InterruptedException {
        iFrame.iFrame();
        Thread.sleep(2000);
        assertEquals("Iframe" , iFrame.textAreaGetText());
    }

    @After
    public void end(){ driver.quit(); }
}
