package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.DragAndDropPage;
import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DragAndDropTests extends BaseTest {
    HomePage homePage;
    DragAndDropPage dragAndDropPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
    }

    @Test
    public void verifyDragAndDropColumnsSwitched() {
        homePage.clickDragAndDropLink();
        dragAndDropPage.dragColumnAtoColumnB();
        Assert.assertEquals("B", dragAndDropPage.getFirstColumnHeaderText());
        Assert.assertEquals("A", dragAndDropPage.getSecondColumnHeaderText());
    }
}
