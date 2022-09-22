package com.mitt.test;

import com.mitt.pages.JsErrorPage;
import com.mitt.pages.NewWindowPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewWIndowTests extends BaseTest{

    NewWindowPage newWindowPage;

    @BeforeClass
    public void setUp(){
        newWindowPage = new NewWindowPage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu() throws InterruptedException {
        newWindowPage.windowVerification();
    }
}
