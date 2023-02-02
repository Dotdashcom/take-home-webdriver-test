package com.academy.techcenture;

import com.academy.techcenture.pages.DynamicLoadingPage;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseClassTest {

    @Test
    public void dynamicLoadingTest(){
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver, softAssert);
        dynamicLoadingPage.navigateTo("/dynamic_loading/2");
        dynamicLoadingPage.verifyDynamicLoading();
    }

}
