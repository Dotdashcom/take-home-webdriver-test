package tests;

import enums.Pages;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import utilities.BrowserUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicControlsTest extends TestBase {

    DynamicControlsPage dynamicControlsPage;

    @Test(description = "Dynamic Control Test")
    public void dynamicControlTest() {
        BrowserUtils.openPage(driver, Pages.DYNAMIC_CONTROLS_PAGE);
        dynamicControlsPage = new DynamicControlsPage();
        BrowserUtils.waitUntilVisible(driver, dynamicControlsPage.header, Duration.ofSeconds(15));
        verifyCheckBoxAGone();
        verifyCheckBoxABack();
        verifyInputEnabled();
        verifyInputDisabled();
    }

    private void verifyMessage(String text) {
        BrowserUtils.waitUntilVisible(driver, dynamicControlsPage.message, Duration.ofSeconds(15));
        assertThat(dynamicControlsPage.message.getText()).contains(text);
    }

    private void verifyCheckBoxAGone() {
        assertThat(dynamicControlsPage.checkboxA.size()).isEqualTo(1);
        dynamicControlsPage.addRemoveBtn.click();
        verifyMessage("It's gone!");
        assertThat(dynamicControlsPage.checkboxA.size()).isEqualTo(0);
    }

    private void verifyCheckBoxABack() {
        dynamicControlsPage.addRemoveBtn.click();
        verifyMessage("It's back!");
        assertThat(dynamicControlsPage.checkboxA.size()).isEqualTo(1);
    }

    private void verifyInputEnabled() {
        assertThat(dynamicControlsPage.textInput.isEnabled()).isFalse();
        dynamicControlsPage.enableDisableBtn.click();
        verifyMessage("It's enabled!");
        assertThat(dynamicControlsPage.textInput.isEnabled()).isTrue();
    }

    private void verifyInputDisabled() {
        dynamicControlsPage.enableDisableBtn.click();
        verifyMessage("It's disabled!");
        assertThat(dynamicControlsPage.textInput.isEnabled()).isFalse();
    }
}
