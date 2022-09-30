package e2e.tests;

import e2e.pages.DynamicControlPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicControlTest extends BaseSpec {
    DynamicControlPage dynamicControlPage;
    public final String dynamicControlEndpoint = configReader.getDynamicControlsEndpoint();

    @BeforeEach
    public void open(){
        dynamicControlPage = new DynamicControlPage(driver);
        dynamicControlPage.visit(dynamicControlEndpoint);
    }

    @Test
    public void validateCheckboxRemovedAdded(){
        Assertions.assertTrue(dynamicControlPage.isCheckboxPresent());
        // Remove
        dynamicControlPage.clickRemoveAddCheckbox();
        Assertions.assertFalse(dynamicControlPage.isCheckboxPresent());
        // Add
        dynamicControlPage.clickRemoveAddCheckbox();
        Assertions.assertTrue(dynamicControlPage.isCheckboxPresent());
    }

    @Test
    public void validateTextInputDisabledEnabled(){
        Assertions.assertFalse(dynamicControlPage.isTextInputEnabled());
        // Enable
        dynamicControlPage.clickEnableDisableTextInput();
        Assertions.assertTrue(dynamicControlPage.isTextInputEnabled());
        // Disable
        dynamicControlPage.clickEnableDisableTextInput();
        Assertions.assertFalse(dynamicControlPage.isTextInputEnabled());
    }

}
