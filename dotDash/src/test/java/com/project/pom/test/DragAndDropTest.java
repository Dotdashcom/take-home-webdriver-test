package com.project.pom.test;

import com.project.pom.page.DragAndDrop;
import com.project.pom.page.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class DragAndDropTest {

    private WebDriver driver;
    DragAndDrop dragAndDrop;

    @Before
    public void setUp(){
        dragAndDrop = new DragAndDrop(driver);
        driver = dragAndDrop.chromeDriverConnection();
        dragAndDrop.visit("/drag_and_drop");
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        assertEquals("A",dragAndDrop.switchedA());
        assertEquals("B",dragAndDrop.switchedB());
        dragAndDrop.dragAndDrop();
        Thread.sleep(1000);
        assertNotEquals("A",dragAndDrop.switchedB());
        assertNotEquals("B",dragAndDrop.switchedA());
    }

    @After
    public void end(){ driver.quit(); }
}
