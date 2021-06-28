package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DynamicControlsPage;
import org.testng.annotations.Test;

public class DynamicControlTest_8 extends BaseClass{

    @Test
    public void DynamicControlTest() {
        driver.get(baseURL);
        DynamicControlsPage dynamicControl = new DynamicControlsPage(driver);
        dynamicControl.clickDynamicControlLink();
        dynamicControl.enableDynamicControlCheckbox();
        dynamicControl.clickDynamicControlRemove();
        dynamicControl.clickDynamicControlAdd();
        dynamicControl.clickDynamicControlEnable();
        dynamicControl.clickDynamicControlDisable();

    }
}
