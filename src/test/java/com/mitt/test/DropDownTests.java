package com.mitt.test;

import com.mitt.pages.DrangAndDropPage;
import com.mitt.pages.DropDownPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownTests extends BaseTest{

    DropDownPage dropdownPage;

    @BeforeClass
    public void setUp(){
        dropdownPage = new DropDownPage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu(){
        dropdownPage.dropdownSelection();
    }
}
