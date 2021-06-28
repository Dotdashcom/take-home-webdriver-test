package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DynamicContentPage;
import org.testng.annotations.Test;
import java.io.IOException;

public class DynamicContentTest_7 extends BaseClass {
    
    @Test
    public void DynamicContentTest()  {
        driver.get(baseURL);
        DynamicContentPage dynamicContent = new DynamicContentPage(driver);

        dynamicContent.clickDynamicContentLink();
        dynamicContent.checkText1();
        dynamicContent.checkText2();
        dynamicContent.checkText3();
    }
    
}
