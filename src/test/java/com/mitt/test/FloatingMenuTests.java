package com.mitt.test;

import com.mitt.pages.FileUploadPage;
import com.mitt.pages.FloatingMenuPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FloatingMenuTests extends BaseTest{

    FloatingMenuPage floatingMenuPage;

    @BeforeClass
    public void setUp(){
        floatingMenuPage = new FloatingMenuPage(getDriver(), getWait());
    }

    @Test
    public void testFloating(){
        floatingMenuPage.testFloatingElement();
    }

}
