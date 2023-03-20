package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

public class DragAndDropTest extends Util{

    protected DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        dragAndDropPage = PageFactory.initElements(driver, DragAndDropPage.class);
    }

    @Test
    public void drag_Drop_Test() throws AWTException, InterruptedException {
        dragAndDropPage.dragAndDrop();
        Assert.assertEquals(dragAndDropPage.getElementA().getText(),"B");
        Assert.assertEquals(dragAndDropPage.getElementB().getText(),"A");

    }
    @AfterMethod
    public void endTest(){
        teardown();
    }
}