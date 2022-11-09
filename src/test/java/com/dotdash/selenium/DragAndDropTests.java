package com.dotdash.selenium;

import com.dotdash.selenium.pages.DragAndDropPage;
import com.dotdash.selenium.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DragAndDropTests extends SetUpTearDown {
    HomePage homePage;
    DragAndDropPage dragAndDropPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
    }

    @Test
    public void verifyDragAndDropColumnsSwitched() throws InterruptedException {
        homePage.clickDragAndDropLink();
        dragAndDropPage.dragColumnAtoColumnB();
        Thread.sleep(3000);
        Assert.assertEquals("B", dragAndDropPage.getFirstColumnHeaderText());
        Assert.assertEquals("A", dragAndDropPage.getSecondColumnHeaderText());
    }
}
