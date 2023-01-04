package scenarios;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DynamicControlsPage;


public class DynamicControlsTest extends BaseTest {
    private DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setup() {
        dynamicControlsPage = homePage.gotoDynamicControlsPage();
    }

    @Test
    public void removeAddCheckboxTest() {
        SoftAssert softAssert = new SoftAssert();

        String messageText = dynamicControlsPage.clickRemoveButton()
                .getMessageText();
        softAssert.assertEquals(messageText, "It's gone!");
        boolean isCheckboxPresent = dynamicControlsPage.isCheckboxPresent();
        softAssert.assertFalse(isCheckboxPresent, "Checkbox should not be present!");

        messageText = dynamicControlsPage.clickAddButton()
                .getMessageText();
        softAssert.assertEquals(messageText, "It's back!");
        isCheckboxPresent = dynamicControlsPage.isCheckboxPresent();
        softAssert.assertTrue(isCheckboxPresent, "Checkbox should be present!");

        softAssert.assertAll();
    }

    @Test
    public void enableDisableInputFieldTest() {
        SoftAssert softAssert = new SoftAssert();

        String messageText = dynamicControlsPage.clickEnableButton()
                .getMessageText();
        softAssert.assertEquals(messageText, "It's enabled!");
        boolean textBoxState = dynamicControlsPage.isTextBoxEnabled();
        softAssert.assertTrue(textBoxState, "Text box should be enabled!");

        messageText = dynamicControlsPage.clickDisableButton()
                .getMessageText();
        softAssert.assertEquals(messageText, "It's disabled!");
        textBoxState = dynamicControlsPage.isTextBoxDisabled();
        softAssert.assertTrue(textBoxState, "Text box should be disabled!");

        softAssert.assertAll();
    }
}