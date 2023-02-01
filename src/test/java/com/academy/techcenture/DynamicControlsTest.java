package com.academy.techcenture;

import com.academy.techcenture.pages.DynamicControlsPage;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseClassTest {

    @Test
    public void asd(){
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver, softAssert);
        dynamicControlsPage.navigateTo("/dynamic_controls");
        dynamicControlsPage.verifyDynamicControls();
    }

}
