package com.framework.testcases;
import com.framework.pages.DynamicContentPage;
import com.framework.testbase.TestBase;
import com.framework.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicContentPageTest extends TestBase {
    DynamicContentPage dynamicContentPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }



    @Test(priority = 1, description = "User is on the dynamic page content ")
    public void user_is_on_dynamic_content_page() {
        dynamicContentPage = new DynamicContentPage(driver);
        dynamicContentPage.navigate();
        String actualURL = dynamicContentPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/dynamic_content";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "New content is displayed page after refresh")
    public void display_new_content() {
        dynamicContentPage = new DynamicContentPage(driver);
        dynamicContentPage.navigate();
        String currentContent;
        String newContent;
        for (int i = 0; i < 5; i++) {
            currentContent = dynamicContentPage.getCurrentContent();
            Utils.refreshPage(driver);
            newContent = dynamicContentPage.getCurrentContent();
            Assert.assertNotEquals(currentContent, newContent);
        }
    }
    @AfterTest
    public void teardown() {
        super.cleanup();
    }
}
