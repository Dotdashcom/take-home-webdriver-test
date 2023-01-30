package com.ddm.testcases;

import com.ddm.pageobjects.DynamicContentPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DynamicContentTests extends BaseTestClass {

    protected DynamicContentPage dynamicContentPage;

    @BeforeMethod
    public void setUpMethodDynamicContent() {
        dynamicContentPage = landingPage.goTo("/dynamic_content", DynamicContentPage.class);
    }

    @Test
    public void allParagraphsChangesTest()  {
        String para1TextBefore = dynamicContentPage.getParagraphText(0);
        String para2TextBefore = dynamicContentPage.getParagraphText(1);
        String para3TextBefore = dynamicContentPage.getParagraphText(2);
        dynamicContentPage.refreshPage();
        String para1TextAfter = dynamicContentPage.getParagraphText(0);
        String para2TextAfter = dynamicContentPage.getParagraphText(1);
        String para3TextAfter = dynamicContentPage.getParagraphText(2);

        SoftAssert sf = new SoftAssert();
        sf.assertNotEquals(para1TextBefore, para1TextAfter, "Paragraph 1 content is NOT updated after refresh.");
        sf.assertNotEquals(para2TextBefore, para2TextAfter, "Paragraph 2 content is NOT updated after refresh.");
        sf.assertNotEquals(para3TextBefore, para3TextAfter, "Paragraph 3 content is NOT updated after refresh.");
        sf.assertAll();
    }

    @Test
    public void onlyLastParaChangesTest()  {
        dynamicContentPage = landingPage.goTo("/dynamic_content?with_content=static", DynamicContentPage.class);
        String para1TextBefore = dynamicContentPage.getParagraphText(0);
        String para2TextBefore = dynamicContentPage.getParagraphText(1);
        String para3TextBefore = dynamicContentPage.getParagraphText(2);
        dynamicContentPage.refreshPage();
        String para1TextAfter = dynamicContentPage.getParagraphText(0);
        String para2TextAfter = dynamicContentPage.getParagraphText(1);
        String para3TextAfter = dynamicContentPage.getParagraphText(2);

        SoftAssert sf = new SoftAssert();
        sf.assertEquals(para1TextBefore, para1TextAfter, "Paragraph 1 content is changed after refresh.");
        sf.assertEquals(para2TextBefore, para2TextAfter, "Paragraph 2 content is changed after refresh.");
        sf.assertNotEquals(para3TextBefore, para3TextAfter, "Paragraph 3 content is NOT updated after refresh.");
        sf.assertAll();
    }
    
}
