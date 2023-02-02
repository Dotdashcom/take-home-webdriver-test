package com.academy.techcenture;

import com.academy.techcenture.pages.JavaScriptErrorPage;
import org.testng.annotations.Test;

public class JavaScriptErrorTest extends BaseClassTest {

    @Test
    public void javaScriptErrorTest(){
        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(driver, softAssert);
        javaScriptErrorPage.navigateTo("/javascript_error");
        javaScriptErrorPage.verifyJavascriptErrors();
    }

}
