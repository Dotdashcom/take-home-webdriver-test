package com.dotdash.testcases;

import com.dotdash.pageObject.DynamicContentPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class DynamicContent extends Setup{
    DynamicContentPage dynamicContentPage;

    public DynamicContent() {
        this.dynamicContentPage = MyTestClasses.getObject(DynamicContentPage.class);
    }


    @Test(testName = "validate dynamic elements")
    public void validateDynamicElements(){
        navigateTo("dynamic_loading/2");
        dynamicContentPage.clickOnStartButton();
        dynamicContentPage.assertDynamicElementDisplayed("Hello World!");
    }


    @Test(testName = "Validate content changes dynamically")
    public void validateContentChangesDynamically(){
        navigateTo("dynamic_content");
        dynamicContentPage.clickToChangeTextDynamically();
        dynamicContentPage.assertContentChangedDynamically();
    }



}
