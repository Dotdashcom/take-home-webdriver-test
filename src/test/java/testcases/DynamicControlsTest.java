package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.DynamicControlsPage;
import org.junit.Test;

public class DynamicControlsTest extends BaseTest {

    public DynamicControlsTest(){
        super();
    }

    @Test
    public void RemoveAndAddCheckbox() throws InterruptedException{
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.clickRemoveButton();
        dynamicControlsPage.assertCheckboxIsRemoved();
        dynamicControlsPage.clickAddButton();
        dynamicControlsPage.assertCheckboxIsAdded();

    }

    @Test
    public void EnableAndDisableInputField() throws InterruptedException{
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        dynamicControlsPage.clickEnableButton();
        dynamicControlsPage.assertInputIsEnabled();
        dynamicControlsPage.clickDisableButton();
        dynamicControlsPage.assertInputIsDisabled();

    }


}
