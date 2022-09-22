package com.mitt.test;

import com.mitt.pages.JsAlertPage;
import com.mitt.pages.JsErrorPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JsErrorTests extends BaseTest{

    JsErrorPage jsErrorPage;

    @BeforeClass
    public void setUp(){
        jsErrorPage = new JsErrorPage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu() throws InterruptedException {
        jsErrorPage.jserrorVerification();
    }
}
