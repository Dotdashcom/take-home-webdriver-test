package com.academy.techcenture;

import com.academy.techcenture.pages.DynamicContentPage;
import org.testng.annotations.Test;

public class DynamicContentTest extends BaseClassTest {

    @Test
    public void dynamicContentTest(){
            DynamicContentPage dynamicContentPage = new DynamicContentPage(driver, softAssert);
            dynamicContentPage.navigateTo("/dynamic_content");
            dynamicContentPage.verifyDynamicContent();
    }

}
