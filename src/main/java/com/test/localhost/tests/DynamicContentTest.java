package com.test.localhost.tests;

import com.test.localhost.pages.DynamicContentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicContentTest extends TestBase {

    @Test
    public void dynamicContentTest(){
        DynamicContentPage dynamicContentPage=new DynamicContentPage(driver);
        dynamicContentPage.clickDynamicContentButton();
        String beforeRefresh=driver.getPageSource();
        driver.navigate().refresh();
        String afterRefresh=driver.getPageSource();
        Assert.assertNotEquals(beforeRefresh,afterRefresh);
    }
}
