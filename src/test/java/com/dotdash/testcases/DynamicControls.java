package com.dotdash.testcases;

import com.dotdash.pageObject.DynamicControlsPage;
import com.framework.libraries.I;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class DynamicControls extends Setup {
    DynamicControlsPage dynamicControlsPage;

    public DynamicControls(){
        this.dynamicControlsPage= MyTestClasses.getObject(DynamicControlsPage.class);

    }

    @Test(testName = "validate dynamic controls")
    public void validateDynamicControls(){
        navigateTo("/dynamic_controls");
        dynamicControlsPage.clickControls(DynamicControlsPage.controls.Remove.name());
        dynamicControlsPage.assertControlsRemove();
        dynamicControlsPage.clickControls(DynamicControlsPage.controls.Add.name());
        dynamicControlsPage.assertControlsAdded();
        dynamicControlsPage.clickControls(DynamicControlsPage.controls.Enable.name());
        dynamicControlsPage.assertControlsEnable();
        dynamicControlsPage.clickControls(DynamicControlsPage.controls.Disable.name());
        dynamicControlsPage.assertControlsDisable();
    }


}
