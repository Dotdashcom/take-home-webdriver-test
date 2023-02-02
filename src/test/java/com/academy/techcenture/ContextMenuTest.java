package com.academy.techcenture;

import com.academy.techcenture.pages.ContextMenuPage;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseClassTest {

    @Test
    public void ContextMenuTest(){
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver, softAssert);
        contextMenuPage.navigateTo("/context_menu");
        contextMenuPage.verifyAlert();
    }


}
