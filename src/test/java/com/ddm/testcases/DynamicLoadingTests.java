package com.ddm.testcases;

import com.ddm.pageobjects.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicLoadingTests extends BaseTestClass {

    protected DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod
    public void setUpMethodDynamicLoading() {
        dynamicLoadingPage = landingPage.goTo("/dynamic_loading/2", DynamicLoadingPage.class);
    }

    @Test
    public void dynamicLoadedElementsTest() {
        dynamicLoadingPage.startDynamicLoadAndWait();
        Assert.assertEquals(dynamicLoadingPage.getLoadedText(), "Hello World!", "Loaded text is different.");
    }
}
