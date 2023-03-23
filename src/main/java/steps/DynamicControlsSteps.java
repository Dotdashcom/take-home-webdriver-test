package steps;

import io.qameta.allure.Step;
import pages.DynamicControlsPage;

public class DynamicControlsSteps {

   DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

   @Step("Check that dynamic checkbox visible/invisible")
   public void checkDisplayDynamicCheckbox() {
        dynamicControlsPage.pressButtonRemoveAdd();
        dynamicControlsPage.checkboxShouldNoBeVisible();
        dynamicControlsPage.pressButtonRemoveAdd();
        dynamicControlsPage.checkboxShouldBeVisible();
    }

    @Step("Check that dynamic input visible/invisible")
    public void checkDisplayDynamicInput(){
        dynamicControlsPage.pressButtonEnableDisable();
        dynamicControlsPage.inputFieldShouldBeEnabled();
        dynamicControlsPage.pressButtonEnableDisable();
        dynamicControlsPage.inputFieldShouldBeDisabled();
    }

}
