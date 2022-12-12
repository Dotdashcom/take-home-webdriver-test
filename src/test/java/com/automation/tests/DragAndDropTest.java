package com.automation.tests;

import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest{

    @Test
    public void test(){
        dragAndDropPage.clickOnLink();
        dragAndDropPage.dragAndDrop();
    }
}
