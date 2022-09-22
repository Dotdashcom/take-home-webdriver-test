package com.mitt.test;

import com.mitt.pages.IFramePage;
import com.mitt.pages.MouseHoverPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseHoverTests extends BaseTest{

    MouseHoverPage mousehoverPage;

    @BeforeClass
    public void setUp(){
        mousehoverPage = new MouseHoverPage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu() throws InterruptedException {
        mousehoverPage.mousehoverVerification();
    }
}
