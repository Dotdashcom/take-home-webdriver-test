package com.project.pom.test;

import com.project.pom.Base;
import com.project.pom.page.ContextMenu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ContextMenuTest {

    private WebDriver driver;
    ContextMenu contextMenu;

    @Before
    public void setUp(){
        contextMenu = new ContextMenu(driver);
        driver = contextMenu.chromeDriverConnection();
        contextMenu.visit("/context_menu");
    }

    @Test
    public void contextMenuTest(){
        contextMenu.clickOnBox();
        assertEquals("You selected a context menu" , contextMenu.validateJSAlert());
    }

    @After
    public void end(){ driver.quit(); }
}
