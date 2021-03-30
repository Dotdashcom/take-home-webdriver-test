package com.DotDash.Scripts;

import com.DotDash.Pages.DynamicContentPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;
public class DynamicContent extends basePage {

    @Test
    public void dynamicContent() {
        driver.get(baseURL + "/dynamic_content");

        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        String s1 = dynamicContentPage.gettxtcontent();
        System.out.println(s1);
        driver.navigate().refresh();
        String s2 = dynamicContentPage.gettxtcontent();
        System.out.println(s2);

        SoftAssert assertion = new SoftAssert();

        assertion.assertNotEquals(s1, s2, "Test Passed!!");
        driver.navigate().refresh();
        String s3 = dynamicContentPage.gettxtcontent();
        System.out.println(s3);

        assertion.assertNotEquals(s2, s3, "Test Passed!!");
        assertion.assertAll();

    }
}
