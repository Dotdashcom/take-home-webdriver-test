package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

public class DragAndDropTest extends BasePage{

    protected DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        dragAndDropPage = PageFactory.initElements(driver, DragAndDropPage.class);
    }

    @Test
    public void dragAndDropTest() throws AWTException, InterruptedException {
        dragAndDropPage.dragAndDrop();
        Assert.assertEquals(dragAndDropPage.getElementA().getText(),"B");
        Assert.assertEquals(dragAndDropPage.getElementB().getText(),"A");

    }
    @AfterMethod
    public void endTest(){
        teardown();
    }
}
