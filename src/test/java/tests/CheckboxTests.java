package tests;

import enums.Headers;
import enums.Pages;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import utilities.BrowserUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxTests extends TestBase {

    @Test(description = "Checkboxes")
    public void verifyCkeckboxes(){
        CheckboxPage checkboxPage = new CheckboxPage();
        BrowserUtils.openPage(driver, Pages.CHECKBOX_PAGE);
        BrowserUtils.waitUntilVisible(driver, checkboxPage.header, Duration.ofSeconds(15));
        assertThat(checkboxPage.header.getText()).isEqualTo(Headers.CHECKBOXES.getName());
        //verify checkbox 1
        assertThat(checkboxPage.checkbox1.isSelected())
                .as("Checkbox 1 should be unchecked")
                .isFalse();
        checkboxPage.checkbox1.click();
        assertThat(checkboxPage.checkbox1.isSelected())
                .as("Checkbox 1 should be checked")
                .isTrue();
        //verify checkbox 2
        assertThat(checkboxPage.checkbox2.isSelected())
                .as("Checkbox 2 should be checked")
                .isTrue();
        checkboxPage.checkbox2.click();
        assertThat(checkboxPage.checkbox2.isSelected())
                .as("Checkbox 2 should be unchecked")
                .isFalse();
    }
}
