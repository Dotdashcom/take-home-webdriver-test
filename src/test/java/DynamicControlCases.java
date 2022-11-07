import org.testng.Assert;
import org.testng.annotations.Test;


public class DynamicControlCases extends Hooks {

    @Test
    public  void DynamicControl() throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.DynamicControls.getOption());

        App.dynamicControlsPage.clickButtonCheckbox();
        Assert.assertFalse(App.dynamicControlsPage.validateCheckboxExist());

        App.dynamicControlsPage.clickButtonCheckbox();
        Assert.assertTrue(App.dynamicControlsPage.validateCheckboxExist());


        App.dynamicControlsPage.clickButtonInput();
        Assert.assertTrue(App.dynamicControlsPage.validateInputEnabled());

        App.dynamicControlsPage.clickButtonInput();
        Assert.assertFalse(App.dynamicControlsPage.validateInputEnabled());
    }
}
