package com.mitt.test;

import com.mitt.pages.JsAlertPage;
import com.mitt.pages.MouseHoverPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JsAlertTests extends BaseTest{

    JsAlertPage jsAlertPage;

    @BeforeClass
    public void setUp(){
        jsAlertPage = new JsAlertPage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu() throws InterruptedException {
        jsAlertPage.alertVerification();
    }
}
