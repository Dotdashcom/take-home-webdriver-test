package dynamic_loading_test;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.dynamic_controls.DynamicControlsPage;
import page_object_model.dynamic_loading.DynamicLoadingPage;

import static org.testng.Assert.assertTrue;

public class DynamicLoadingTest extends Base {
    @Test
    public void dynamicLoadingTest(){
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.clickStartButton();
        waitForVisibilityOfElement(DynamicLoadingPage.helloWordMessage);
        assertTrue(DynamicLoadingPage.helloWordMessage.isDisplayed());

    }
}
