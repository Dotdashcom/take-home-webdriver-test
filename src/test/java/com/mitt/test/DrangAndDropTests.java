package com.mitt.test;

import com.mitt.pages.ContextMenuPage;
import com.mitt.pages.DrangAndDropPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DrangAndDropTests  extends BaseTest{

    DrangAndDropPage drangAndDropPage;

    @BeforeClass
    public void setUp(){
        drangAndDropPage = new DrangAndDropPage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu(){
        drangAndDropPage.dragAndDropFromAtoB();
    }
}
