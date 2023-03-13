package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptErrorTest extends BasePage{
    protected JavaScriptErrorPage javaScriptErrorPage;

    @BeforeClass
    public void setUp(){
        driver = getDriver();
        javaScriptErrorPage = PageFactory.initElements(driver, JavaScriptErrorPage.class);
    }

    @Test
    public void jsErrorTest() throws InterruptedException {
        Assert.assertTrue(javaScriptErrorPage.jsErrorCheck().contains("http://localhost:7080/javascript_error 6:51 Uncaught TypeError: Cannot read properties of undefined (reading 'xyz')"));
    }
    @AfterClass
    public void endTest(){
        teardown();
    }


}
