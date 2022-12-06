package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.DynamicContentPage;

public class DynamicContentTest extends TestBase{

    DynamicContentPage dynamicContentPage;

    public DynamicContentTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/dynamic_content");
        dynamicContentPage = new DynamicContentPage();
    }

    @Test()
    public void verifyPageDynamicContent() {

        dynamicContentPage.clickLinkText();
        driver.navigate().refresh();
        String text_1 = dynamicContentPage.getDynamicTextElement().getText();

        driver.navigate().refresh();
        String text_2 = dynamicContentPage.getDynamicTextElement().getText();

        Assert.assertNotEquals(text_1,text_2);
        }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
